package br.com.fiap.upperBank.models;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Entity;

public class Conta {
    private Long id;

    private int agencia;

    private int conta;

    private int digito;

    private List<Cliente> cliente;

    private List<Movimentacao> movimentacao;

    private Calendar dataAbertura;

    private int senha;

    private char status;

    private double saldo;

    private double limite;

    public Conta(int agencia, int conta, int digito, List<Cliente> cliente, List<Movimentacao> movimentacao,
            Calendar dataAbertura, int senha, char status, double saldo, double limite) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.cliente = cliente;
        this.movimentacao = movimentacao;
        this.dataAbertura = dataAbertura;
        this.senha = senha;
        this.status = status;
        this.saldo = saldo;
        this.limite = limite;
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

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public List<Movimentacao> getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(List<Movimentacao> movimentacao) {
        this.movimentacao = movimentacao;
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

    @Override
    public String toString() {
        return "Conta [id=" + id + ", agencia=" + agencia + ", conta=" + conta + ", digito=" + digito + ", cliente="
                + cliente + ", movimentacao=" + movimentacao + ", dataAbertura=" + dataAbertura + ", senha=" + senha
                + ", status=" + status + ", saldo=" + saldo + ", limite=" + limite + "]";
    }

}
