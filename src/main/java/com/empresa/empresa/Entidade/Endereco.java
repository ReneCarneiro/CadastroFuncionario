package com.empresa.empresa.Entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "listaendereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String lagradouro;
    private String numero;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    public Endereco() {
    }

    public Endereco(Long id, String cep, String estado, String cidade, String bairro, String lagradouro, String numero, Funcionario funcionario) {
        this.id = id;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.lagradouro = lagradouro;
        this.numero = numero;
        this.funcionario = funcionario;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(cep, endereco.cep)
                && Objects.equals(estado, endereco.estado) && Objects.equals(cidade, endereco.cidade)
                && Objects.equals(bairro, endereco.bairro) && Objects.equals(lagradouro, endereco.lagradouro)
                && Objects.equals(numero, endereco.numero) && Objects.equals(funcionario, endereco.funcionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, estado, cidade, bairro, lagradouro, numero, funcionario);
    }

    @Override
    public String toString() {
        final StringBuilder endereco = new StringBuilder("Endereco{");
        endereco.append("id=").append(id);
        endereco.append(", cep='").append(cep).append('\'');
        endereco.append(", estado='").append(estado).append('\'');
        endereco.append(", cidade='").append(cidade).append('\'');
        endereco.append(", bairro='").append(bairro).append('\'');
        endereco.append(", lagradouro='").append(lagradouro).append('\'');
        endereco.append(", numero='").append(numero).append('\'');
        endereco.append(", funcionario=").append(funcionario);
        endereco.append('}');
        return endereco.toString();
    }
}

