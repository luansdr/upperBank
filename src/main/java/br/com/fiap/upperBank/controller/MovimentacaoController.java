package br.com.fiap.upperBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.upperBank.models.Conta;
import br.com.fiap.upperBank.models.Movimentacao;
import br.com.fiap.upperBank.repository.MovimentacaoRepository;;

@RestController
@RequestMapping("api/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Movimentacao>> show() {
        List<Movimentacao> movimentacoes = movimentacaoRepository.findAll();
        return movimentacoes.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(movimentacoes);
    }

    // GET DETAILS
    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> show(@PathVariable Long id) {
        var movimentacoesEncontradas = movimentacaoRepository.findById(id);
        if (movimentacoesEncontradas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(movimentacoesEncontradas.get());
    }

    // POST
    @ResponseBody
    @PostMapping
    public ResponseEntity<Movimentacao> create(@RequestBody Movimentacao movimentacao) {

        movimentacaoRepository.save(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacao);
    }

    // PUT
    @PutMapping
    public ResponseEntity<Movimentacao> update(@RequestBody Movimentacao movimentacao) {

        var movimentacoesEncontradas = movimentacaoRepository.findById(movimentacao.getId());

        if (movimentacoesEncontradas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        movimentacaoRepository.save(movimentacao);

        return ResponseEntity.ok().body(movimentacao);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Conta> delete(@PathVariable Long id) {

        var movimentacoesEncontradas = movimentacaoRepository.findById(id);

        if (movimentacoesEncontradas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        movimentacaoRepository.delete(movimentacoesEncontradas.get());

        return ResponseEntity.noContent().build();
    }
}