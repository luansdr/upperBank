package br.com.fiap.upperBank.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.upperBank.models.Movimentacao;
import br.com.fiap.upperBank.repository.MovimentacaoRepository;;
@RestController
@RequestMapping("api/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @GetMapping
    public List<Movimentacao> getMovimentacoes() {
        return movimentacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> getMovimentacaoById(@PathVariable Long id) {
        Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
        if (movimentacao.isPresent()) {
            return ResponseEntity.ok(movimentacao.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Movimentacao> createMovimentacao(@RequestBody Movimentacao movimentacao) {
        movimentacao = movimentacaoRepository.save(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimentacao> updateMovimentacao(@PathVariable Long id, @RequestBody Movimentacao movimentacaoAtualizada) {
        Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
        if (movimentacao.isPresent()) {
            movimentacaoAtualizada.setId(movimentacao.get().getId());
            movimentacaoAtualizada = movimentacaoRepository.save(movimentacaoAtualizada);
            return ResponseEntity.ok(movimentacaoAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimentacao(@PathVariable Long id) {
        Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
        if (movimentacao.isPresent()) {
            movimentacaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
