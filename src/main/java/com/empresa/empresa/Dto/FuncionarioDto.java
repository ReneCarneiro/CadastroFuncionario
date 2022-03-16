package com.empresa.empresa.Dto;

import com.empresa.empresa.Entidade.Funcionario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String cpf;

    private LocalDate dataNascimento;

    private String nomeMae;

    private List<EnderecoDto> enderecos = new ArrayList<>();

    public FuncionarioDto() {

    }

    public FuncionarioDto(Funcionario entity) {
        id = entity.getId();
        nome = entity.getNome();
        cpf = entity.getCpf();
        dataNascimento = entity.getDataNascimento();
        nomeMae = entity.getNomeMae();
        enderecos = entity.getEnderecos().stream().map(EnderecoDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }
}
