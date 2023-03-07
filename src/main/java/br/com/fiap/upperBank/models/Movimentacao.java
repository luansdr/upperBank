package br.com.fiap.upperBank.models;

import java.util.Calendar;

public class Movimentacao {

    private int id;

    private String nome;

    private int tipo;

    private int agenciaDestino;

    private int contaDestino;

    private int digitoContaDestino;

    private Calendar data;

    private char status;

    private double valor;

    private String descricao;

    public Movimentacao(String nome, int tipo, int agenciaDestino, int contaDestino,
            int digitoContaDestino,
            Calendar data, char status, double valor, String descricao) {
        this.nome = nome;
        this.tipo = tipo;
        this.agenciaDestino = agenciaDestino;
        this.contaDestino = contaDestino;
        this.digitoContaDestino = digitoContaDestino;
        this.data = data;
        this.status = status;
        this.valor = valor;
        this.descricao = descricao;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getAgenciaDestino() {
        return agenciaDestino;
    }

    public void setAgenciaDestino(int agenciaDestino) {
        this.agenciaDestino = agenciaDestino;
    }

    public int getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(int contaDestino) {
        this.contaDestino = contaDestino;
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

    @Override
    public String toString() {
        return "Movimentacao [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", agenciaDestino=" + agenciaDestino
                + ", contaDestino=" + contaDestino + ", digitoContaDestino=" + digitoContaDestino + ", data=" + data
                + ", status=" + status + ", valor=" + valor + ", descricao=" + descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
