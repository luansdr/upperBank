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
import br.com.fiap.upperBank.repository.MovimentacaoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Movimentação")
@RequestMapping("api/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @GetMapping
    @Operation(summary = "Listar todas as movimentações", description = "Retorna uma lista com todas as movimentações cadastradas.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de movimentações encontrada"),
        @ApiResponse(responseCode = "204", description = "Nenhuma movimentação encontrada")
    })
    public ResponseEntity<List<Movimentacao>> show() {
        List<Movimentacao> movimentacoes = movimentacaoRepository.findAll();
        return movimentacoes.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(movimentacoes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar detalhes de uma movimentação", description = "Retorna os detalhes de uma movimentação específica.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Movimentação encontrada"),
        @ApiResponse(responseCode = "404", description = "Movimentação não encontrada")
    })
    public ResponseEntity<Movimentacao> show(@PathVariable Long id) {
        var movimentacoesEncontradas = movimentacaoRepository.findById(id);
        if (movimentacoesEncontradas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(movimentacoesEncontradas.get());
    }

    @ResponseBody
    @PostMapping
    @Operation(summary = "Criar uma nova movimentação", description = "Cria uma nova movimentação.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Movimentação criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos, a validação falhou")
    })
    public ResponseEntity<Movimentacao> create(@Valid @RequestBody Movimentacao movimentacao) {

        movimentacaoRepository.save(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacao);
    }

    @PutMapping
    @Operation(summary = "Atualizar uma movimentação", description = "Atualiza uma movimentação existente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Movimentação atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Movimentação não encontrada")
    })
    public ResponseEntity<Movimentacao> update(@Valid @RequestBody Movimentacao movimentacao) {

        var movimentacoesEncontradas = movimentacaoRepository.findById(movimentacao.getId());

        if (movimentacoesEncontradas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        movimentacaoRepository.save(movimentacao);

        return ResponseEntity.ok().body(movimentacao);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Excluir uma movimentação", description = "Exclui uma movimentação existente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Movimentação excluída com sucesso"),
        @ApiResponse(responseCode = "404", description = "Movimentação não encontrada")
    })
    public ResponseEntity<Conta> delete(@PathVariable Long id) {

        var movimentacoesEncontradas = movimentacaoRepository.findById(id);

        if (movimentacoesEncontradas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        movimentacaoRepository.delete(movimentacoesEncontradas.get());

        return ResponseEntity.noContent().build();
    }
}
