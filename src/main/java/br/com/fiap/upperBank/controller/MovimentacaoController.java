package br.com.fiap.upperBank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.upperBank.models.Conta;
import br.com.fiap.upperBank.models.Movimentacao;;

@RestController
public class MovimentacaoController {

    List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();

    // GET ALL
    @GetMapping("/api/movimentacao")
    public ResponseEntity<List<Movimentacao>> show() {
        return movimentacoes.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(movimentacoes);
    }

    // GET DETAILS
    @GetMapping("/api/movimentacao/{id}")
    public ResponseEntity<Movimentacao> show(@PathVariable Long id) {

        var movimentacoesEncontradas = movimentacoes.stream().filter(c -> c.getId().equals(id)).findFirst();
        if (movimentacoesEncontradas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movimentacoesEncontradas.get());
    }

    // POST
    @ResponseBody
    @PostMapping("api/movimentacao")
    public ResponseEntity<Movimentacao> create(@RequestBody Movimentacao movimentacao) {

        movimentacao.setId(movimentacoes.size() + 1l);
        movimentacoes.add(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacao);
    }

    // PUT
    @PutMapping("/api/movimentacao/{id}")
    public ResponseEntity<Movimentacao> update(@PathVariable Long id, @RequestBody Movimentacao movimentacao) {

        var movimentacoesEncontradas = movimentacoes.stream().filter(c -> c.getId().equals(id)).findFirst();

        if (movimentacoesEncontradas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        movimentacoes.remove(movimentacoesEncontradas.get());
        movimentacao.setId(id);
        movimentacoes.add(movimentacao);

        return ResponseEntity.ok().body(movimentacao);
    }

    // DELETE
    @DeleteMapping("/api/movimentacao/{id}")
    public ResponseEntity<Conta> delete(@PathVariable Long id) {

        var movimentacoesEncontradas = movimentacoes.stream().filter(c -> c.getId().equals(id)).findFirst();

        if (movimentacoesEncontradas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        movimentacoes.remove(movimentacoesEncontradas.get());

        return ResponseEntity.noContent().build();
    }
}