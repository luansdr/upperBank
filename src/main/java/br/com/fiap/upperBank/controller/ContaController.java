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

import br.com.fiap.upperBank.exceptions.RestNotFoundException;
import br.com.fiap.upperBank.models.Cliente;
import br.com.fiap.upperBank.models.Conta;
import br.com.fiap.upperBank.repository.ClienteRepository;
import br.com.fiap.upperBank.repository.ContaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/conta")
@Tag(name = "Conta")

public class ContaController {

  @Autowired
  private ContaRepository contaRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  // GET ALL
  @GetMapping
  @Operation(summary = "Listar todas as contas", description = "Retorna uma lista com todas as contas cadastradas.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de contas encontrada"),
      @ApiResponse(responseCode = "204", description = "Nenhuma conta encontrada")
  })
  public ResponseEntity<List<Conta>> show() {
    List<Conta> contas = contaRepository.findAll();
    contas.forEach(c -> System.out.println(c));
    return contas.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(contas);

  }

  // GET DETAILS
  @Operation(summary = "Buscar detalhes de uma conta", description = "Retorna os detalhes de uma conta específica.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Conta encontrada"),
      @ApiResponse(responseCode = "404", description = "Conta não encontrada")
  })
  @GetMapping("/{id}")
  public ResponseEntity<Conta> show(@PathVariable Long id) {

    var contasEncontrada = contaRepository.findById(id);

    return contasEncontrada.isEmpty()
        ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(contasEncontrada.get());
  }

  @PostMapping("/{id}")
  @Operation(summary = "Criar uma nova conta para um cliente", description = "Cria uma nova conta para um cliente específico.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Conta criada com sucesso"),
      @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
  })
  public ResponseEntity<?> criarContaParaCliente(@Valid  @PathVariable Long id, @RequestBody Conta conta) {

    Optional<Cliente> optionalCliente = clienteRepository.findById(getConta(id).getId());

    if (optionalCliente.isPresent()) {
      Cliente clientes = optionalCliente.get();
      contaRepository.save(conta);

      // clientes.getContas().add(conta);
      clienteRepository.save(clientes);

      return ResponseEntity.ok().body(conta);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // PUT
  @PutMapping
  @Operation(summary = "Atualizar uma conta", description = "Atualiza uma conta existente.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Conta atualizada com sucesso"),
      @ApiResponse(responseCode = "404", description = "Conta não encontrada")
  })
  public ResponseEntity<Conta> update(@Valid @RequestBody Conta conta) {

    var contasEncontrada = contaRepository.findById(conta.getId());

    if (contasEncontrada.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    contaRepository.save(conta);

    return ResponseEntity.ok().body(conta);
  }

  // DELETE
  @DeleteMapping("/{id}")
  @Operation(summary = "Excluir uma conta", description = "Exclui uma conta existente.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Conta excluída com sucesso"),
      @ApiResponse(responseCode = "404", description = "Conta não encontrada")
  })
  public ResponseEntity<Conta> delete(@PathVariable Long id) {

    var contasEncontrada = contaRepository.findById(id);

    if (contasEncontrada.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    contaRepository.delete(contasEncontrada.get());

    return ResponseEntity.noContent().build();
  }

  private Conta getConta(Long id) {
    return contaRepository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
}
  

}