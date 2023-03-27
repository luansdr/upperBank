package br.com.fiap.upperBank.controller;

import java.util.Calendar;
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
import org.springframework.web.bind.annotation.ResponseStatus;
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

  @GetMapping
  public List<Conta> listar() {
    return contaRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Conta> buscar(@PathVariable Long id) {
    Optional<Conta> conta = contaRepository.findById(id);

    if (conta.isPresent()) {
      return ResponseEntity.ok(conta.get());
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Conta adicionar(@Valid @RequestBody Conta conta) {
      conta.setDataAbertura(Calendar.getInstance());
      conta.setStatus('A');
      
      List<Cliente> clientes = conta.getcliente();
      for (Cliente cliente : clientes) {
          Optional<Cliente> clienteExistente = clienteRepository.findBycpf(cliente.getCpf());
          if (clienteExistente.isPresent()) {
              cliente = clienteExistente.get();
          }

      
          // cliente.addConta(conta);
          clienteRepository.save(cliente);
        }
      
      return contaRepository.save(conta);
  }
  

  @PutMapping("/{id}")
  public ResponseEntity<Conta> atualizar(@PathVariable Long id, @Valid @RequestBody Conta conta) {
    if (!contaRepository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }

    conta.setId(id);
    conta.setStatus('A');
    conta.setDataAbertura(Calendar.getInstance());
    contaRepository.save(conta);

    return ResponseEntity.ok(conta);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> remover(@PathVariable Long id) {
    if (!contaRepository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }

    contaRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
