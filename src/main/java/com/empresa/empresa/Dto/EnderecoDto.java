package com.empresa.empresa.Dto;

import com.empresa.empresa.Entidade.Endereco;

import java.io.Serializable;

public class EnderecoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String lagradouro;
    private String numero;


    public EnderecoDto() {

    }

    public EnderecoDto(Endereco entiti) {
        id = entiti.getId();
        cep = entiti.getCep();
        estado = entiti.getEstado();
        cidade = entiti.getCidade();
        bairro = entiti.getBairro();
        lagradouro = entiti.getLagradouro();
        numero = entiti.getNumero();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLagradouro() {
        return lagradouro;
    }

    public void setLagradouro(String lagradouro) {
        this.lagradouro = lagradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
