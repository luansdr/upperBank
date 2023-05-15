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

import br.com.fiap.upperBank.models.Cliente;
import br.com.fiap.upperBank.models.Conta;
import br.com.fiap.upperBank.repository.ClienteRepository;
import br.com.fiap.upperBank.repository.ContaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/conta")
public class ContaController {

  @Autowired
  private ContaRepository contaRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  // GET ALL
  @GetMapping
  public ResponseEntity<List<Conta>> show() {
    List<Conta> contas = contaRepository.findAll();
    contas.forEach(c -> System.out.println(c));
    return contas.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(contas);

  }

  // GET DETAILS
  @GetMapping("/{id}")
  public ResponseEntity<Conta> show(@PathVariable Long id) {

    var contasEncontrada = contaRepository.findById(id);

    return contasEncontrada.isEmpty()
        ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(contasEncontrada.get());
  }

  @PostMapping("/{id}")
  public ResponseEntity<?> criarContaParaCliente(@Valid  @PathVariable Long id, @RequestBody Conta conta) {

    Optional<Cliente> optionalCliente = clienteRepository.findById(id);

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
  public ResponseEntity<Conta> delete(@PathVariable Long id) {

    var contasEncontrada = contaRepository.findById(id);

    if (contasEncontrada.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    contaRepository.delete(contasEncontrada.get());

    return ResponseEntity.noContent().build();
  }

}