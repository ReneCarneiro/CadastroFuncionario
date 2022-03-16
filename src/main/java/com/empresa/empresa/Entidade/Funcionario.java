package com.empresa.empresa.Entidade;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "nome_mae")
    private String nomeMae;

    @OneToMany(mappedBy = "funcionario")
    private List<Endereco> enderecos = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, String nomeMae) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.nomeMae = nomeMae;
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario funcionario = (Funcionario) o;
        return id.equals(funcionario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder funcionario = new StringBuilder("Funcionario{");
        funcionario.append("id=").append(id);
        funcionario.append(", nome='").append(nome).append('\'');
        funcionario.append(", cpf='").append(cpf).append('\'');
        funcionario.append(", dataNascimento=").append(dataNascimento);
        funcionario.append(", nomeMae='").append(nomeMae).append('\'');
        funcionario.append(", enderecos=").append(enderecos);
        funcionario.append('}');
        return funcionario.toString();
    }
}

