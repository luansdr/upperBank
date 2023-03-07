package br.com.fiap.upperBank.controller;
import java.util.Calendar;

import org.springframework.web.bind.annotation.*;

import br.com.fiap.upperBank.models.Movimentacao;;

@RestController
public class MovimentacaoController {

    @GetMapping("/api/movimentacao")
    public Movimentacao show(){
        var movimentacao = new Movimentacao("Pagamento", 5, 1231, 12343, 1, Calendar.getInstance(), 'A', 0, "Pagamento");
        return movimentacao;
    }
}