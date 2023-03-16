package br.com.fiap.upperBank.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
public class ContaController {

  static List<Conta> contas = new ArrayList<Conta>();

  Logger log = LoggerFactory.getLogger(ContaController.class);

  // GET ALL
  @GetMapping("/api/conta")
  public ResponseEntity<List<Conta>> show() {

    return contas.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(contas);

  }

  // GET DETAILS
  @GetMapping("/api/conta/{id}")
  public ResponseEntity<Conta> show(@PathVariable Long id) {

    var contasEncontrada = contas.stream().filter(c -> c.getId().equals(id)).findFirst();

    return contasEncontrada.isEmpty()
        ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(contasEncontrada.get());
  }

  // POST
  @ResponseBody
  @PostMapping("api/conta")
  public ResponseEntity<Conta> create(@RequestBody Conta conta) {

    conta.setId(contas.size() + 1l);
    contas.add(conta);
    return ResponseEntity.status(HttpStatus.CREATED).body(conta);
  }

  // PUT
  @PutMapping("/api/conta/{id}")
  public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta conta) {

    var contasEncontrada = contas.stream().filter(c -> c.getId().equals(id)).findFirst();

    if (contasEncontrada.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    contas.remove(contasEncontrada.get());
    conta.setId(id);
    contas.add(conta);

    return ResponseEntity.ok().body(conta);
  }

  // DELETE
  @DeleteMapping("/api/conta/{id}")
  public ResponseEntity<Conta> delete(@PathVariable Long id) {

    var contasEncontrada = contas.stream().filter(c -> c.getId().equals(id)).findFirst();

    if (contasEncontrada.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    contas.remove(contasEncontrada.get());

    return ResponseEntity.noContent().build();
  }

}