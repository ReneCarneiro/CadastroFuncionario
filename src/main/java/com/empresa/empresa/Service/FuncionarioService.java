package com.empresa.empresa.Service;


import com.empresa.empresa.Dto.FuncionarioDto;
import com.empresa.empresa.Entidade.Funcionario;
import com.empresa.empresa.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @Transactional
    public FuncionarioDto save(FuncionarioDto dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setNomeMae(dto.getNomeMae());
        funcionario.setDataNascimento(dateIsValid(dto.getDataNascimento()));
        funcionarioRepository.save(funcionario);
        return new FuncionarioDto(funcionario);
    }

    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario findById(Long id) {
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.get();
    }


    public Page<Funcionario> findAll(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);

    }

    public Funcionario update(Long id, Funcionario obj) {
        Funcionario entity = funcionarioRepository.getById(id);
        updateData(entity, obj);
        return funcionarioRepository.save(entity);
    }

    private void updateData(Funcionario entity, Funcionario obj) {
        entity.setNome(obj.getNome());
        entity.setDataNascimento(obj.getDataNascimento());
        entity.setNomeMae(obj.getNomeMae());
    }

    private LocalDate dateIsValid(LocalDate dataNascimento) {
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento informada é inválida");
        } else {
            return dataNascimento;
        }
    }
}