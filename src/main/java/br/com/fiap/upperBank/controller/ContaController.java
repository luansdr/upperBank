package br.com.fiap.upperBank.controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.upperBank.models.Cliente;
import br.com.fiap.upperBank.models.Conta;
import br.com.fiap.upperBank.models.Movimentacao;

@RestController
public class ContaController {

    @GetMapping("/api/conta")
    public Conta show(){
        var cliente = new Cliente("40587128801", "Luan Reis", Calendar.getInstance());
        var movimentacao = new Movimentacao("Pagamento de conta", 'A', 1231, 12343, 1, Calendar.getInstance(), 'A', 0, "Pagamento");
       
        List<Cliente> arrayCliente = new ArrayList<Cliente>();
        List<Movimentacao>arrayMovimentacao = new ArrayList<Movimentacao>();

        arrayCliente.add(cliente);
        arrayMovimentacao.add(movimentacao);

      var conta = new Conta(1234, 44444, 1, arrayCliente ,arrayMovimentacao , Calendar.getInstance(), 12345678, 'A', 0, 0);
        return conta;
    }
}