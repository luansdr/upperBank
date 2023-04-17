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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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

}
