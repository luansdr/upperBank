package br.com.fiap.upperBank.models;


import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Movimentacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String tipo;
    
    private int agenciaDestino;
    
    private int numeroContaDestino;
    
    private int digitoContaDestino;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar data;
    
    @Column(nullable = false)
    private char status;
    
    @Column(nullable = false)
    private double valor;
    
    private String descricao;

    public Movimentacao(String nome, String tipo, int agenciaDestino, int numeroContaDestino,
            int digitoContaDestino, Calendar data, char status, double valor, String descricao, Conta conta) {
        this.nome = nome;
        this.tipo = tipo;
        this.agenciaDestino = agenciaDestino;
        this.numeroContaDestino = numeroContaDestino;
        this.digitoContaDestino = digitoContaDestino;
        this.data = data;
        this.status = status;
        this.valor = valor;
        this.descricao = descricao;
        this.conta = conta;
    }

    protected Movimentacao() {
    }

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAgenciaDestino() {
        return agenciaDestino;
    }

    public void setAgenciaDestino(int agenciaDestino) {
        this.agenciaDestino = agenciaDestino;
    }

    public int getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public void setNumeroContaDestino(int numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }

    public int getDigitoContaDestino() {
        return digitoContaDestino;
    }

    public void setDigitoContaDestino(int digitoContaDestino) {
        this.digitoContaDestino = digitoContaDestino;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
