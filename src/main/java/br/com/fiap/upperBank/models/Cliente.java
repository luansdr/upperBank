package br.com.fiap.upperBank.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Cliente {

    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dataNascimento;

    @ManyToMany(mappedBy = "cliente")
    private List<Conta> contas;

    public Cliente(String cpf, String nome, Calendar dataNascimento, List<Conta> contas) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.contas = contas;
    }

    protected Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void addConta(Conta conta) {
        if (contas == null) {
            contas = new ArrayList<>();
        }
        contas.add(conta);
        conta.getcliente().add(this);
    }

}
