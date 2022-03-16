package com.empresa.empresa.Controllers;


import com.empresa.empresa.Dto.FuncionarioDto;
import com.empresa.empresa.Entidade.Funcionario;
import com.empresa.empresa.Repository.FuncionarioRepository;
import com.empresa.empresa.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {


    @Autowired
    private FuncionarioService funcionarioService;
    private FuncionarioRepository funcionarioRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        Funcionario obj = funcionarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<Funcionario>> getAllFuncionario(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDto> saveFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) {
        funcionarioDto = funcionarioService.save(funcionarioDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionarioDto.getId()).toUri();
        return ResponseEntity.created(uri).body(funcionarioDto);
    }

    @PutMapping("/{id}")
    //public ResponseEntity<FuncionarioDto> atualizar((@PathVariable Long id, @RequestBody Funcionario obj) {
    public ResponseEntity<Funcionario> updatefuncionario(@PathVariable Long id, @RequestBody Funcionario obj) {
        obj = funcionarioService.update(id, obj);
        return ResponseEntity.ok().body(obj);

    }
}


