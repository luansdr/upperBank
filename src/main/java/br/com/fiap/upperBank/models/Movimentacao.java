package br.com.fiap.upperBank.models;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String tipo;

    @Min(value = 1000, message = "O campo 'agenciaDestino' deve conter exatamente 4 dígitos.")
    @Max(value = 9999, message = "O campo 'agenciaDestino' deve conter exatamente 4 dígitos.")
    @Positive
    private int agenciaDestino;

    @Min(value = 10000, message = "O campo 'numeroContaDestino' deve conter exatamente 5 dígitos.")
    @Max(value = 99999, message = "O campo 'numeroContaDestino' deve conter exatamente 5 dígitos.")
    @Positive
    private int numeroContaDestino;
    
    @Min(value = 1, message = "O campo 'digitoContaDestino' deve conter exatamente 1 dígito.")
    @Max(value = 1, message = "O campo 'digitoContaDestino' deve conter exatamente 1 dígito.")
    @Positive
    private int digitoContaDestino;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar data;

    @NotNull
    private char status;

    @NotNull
    @Min(value = 0)
    private double valor;

    @NotBlank
    private String descricao;

    @ManyToOne
    private Conta conta;
}
