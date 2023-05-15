package br.com.fiap.upperBank.models;

public record Token(
    String token,
    String type,
    String prefix
) {}