package br.com.fiap.upperBank.models;

import java.util.Calendar;

public class Cliente {

    private String id_cpf;

    private String nome;

    private Calendar dataNascimento;


    public Cliente(String id_cpf, String nome, Calendar dataNascimento) {
        this.id_cpf = id_cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + id_cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + "]";
    }

    public String getCpf() {
        return id_cpf;
    }

    public void setCpf(String id_cpf) {
        this.id_cpf = id_cpf;
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


    

}
