package br.com.fiap.upperBank.models;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1000, message = "O campo 'agencia' deve conter exatamente 4 dígitos.")
    @Max(value = 9999, message = "O campo 'agencia' deve conter exatamente 4 dígitos.")
    @Positive
    private int agencia;

    @Min(value = 10000, message = "O campo 'conta' deve conter exatamente 5 dígitos.")
    @Max(value = 99999, message = "O campo 'conta' deve conter exatamente 5 dígitos.")
    @Positive
    private int conta;

    @Min(value = 1, message = "O campo 'digito' deve conter exatamente 1 dígito.")
    @Max(value = 1, message = "O campo 'digito' deve conter exatamente 1 dígito.")
    @Positive
    private int digito;

    @ManyToMany(mappedBy = "contas")
    private List<Cliente> cliente;

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;

    @NotNull
    private Calendar dataAbertura;

    @NotNull
    @Size(min = 8)
    private String senha;

    
    @NotNull
    private char status;

    @NotNull
    @Min(value = 0)
    private double saldo;

    @NotNull
    @Min(value = 0)
    private double limite;

    public Conta(int agencia, int conta, int digito, List<Cliente> cliente, List<Movimentacao> movimentacoes,
            Calendar dataAbertura, String senha, char status, double saldo, double limite) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
