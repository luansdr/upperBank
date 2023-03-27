package br.com.fiap.upperBank.models;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int agencia;

    private int conta;

    private int digito;

    @ManyToMany(mappedBy = "contas")
    private List<Cliente> cliente;

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;

    private Calendar dataAbertura;

    private int senha;

    private char status;

    private double saldo;

    private double limite;

    public Conta(int agencia, int conta, int digito, List<Cliente> cliente, List<Movimentacao> movimentacoes,
            Calendar dataAbertura, int senha, char status, double saldo, double limite) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.cliente = cliente;
        this.movimentacoes = movimentacoes;
        this.dataAbertura = dataAbertura;
        this.senha = senha;
        this.status = status;
        this.saldo = saldo;
        this.limite = limite;
    }

    protected Conta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setcliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacao(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

}
