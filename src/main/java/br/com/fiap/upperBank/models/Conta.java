
package br.com.fiap.upperBank.models;


import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Conta {
    
    @Id
    @Column(name = "conta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private int agencia;
    
    @Column(nullable = false)
    private int numero;
    
    @Column(nullable = false)
    private int digito;
    
    @ManyToMany
    @JoinTable(name = "conta_cliente",
            joinColumns = @JoinColumn(name = "conta_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id"))
    private List<Cliente> cliente;
    
    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dataAbertura;
    
    @Column(nullable = false)
    private int senha;
    
    @Column(nullable = false)
    private char status;
    
    @Column(nullable = false)
    private double saldo;
    
    @Column(nullable = false)
    private double limite;

    protected Conta() {
    }

    public Conta(int agencia, int numero, int digito, List<Cliente> cliente, List<Movimentacao> movimentacoes,
            Calendar dataAbertura, int senha, char status, double saldo, double limite) {
        this.agencia = agencia;
        this.numero = numero;
        this.digito = digito;
        this.cliente = cliente;
        this.movimentacoes = movimentacoes;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public List<Cliente> getcliente() {
        return cliente;
    }

    public void setcliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    

    
    
    
}
