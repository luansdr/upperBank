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

import br.com.fiap.upperBank.models.Cliente;

@RestController
public class ClienteController {

    List<Cliente> clientes = new ArrayList<Cliente>();

    // GET ALL
    @GetMapping("/api/cliente")
    public ResponseEntity<List<Cliente>> show() {
        return clientes.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(clientes);
    }

    // GET DETAILS
    @GetMapping("/api/cliente/{id}")
    public ResponseEntity<Cliente> show(@PathVariable String cpf) {

        var clientesEncontrada = clientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst();

        return clientesEncontrada.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.ok(clientesEncontrada.get());

    }

    // POST
    @ResponseBody
    @PostMapping("api/cliente")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        clientes.add(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    // PUT
    @PutMapping("/api/cliente")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {

        var clientesEncontrada = clientes.stream().filter(c -> c.getCpf().equals(cliente.getCpf())).findFirst();

        if (clientesEncontrada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        clientes.remove(clientesEncontrada.get());
        clientes.add(cliente);

        return ResponseEntity.ok().body(cliente);
    }

    // DELETE
    @DeleteMapping("/api/cliente/{cpf}")
    public ResponseEntity<Cliente> delete(@PathVariable String cpf) {

        var clientesEncontrada = clientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst();

        if (clientesEncontrada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        clientes.remove(clientesEncontrada.get());

        return ResponseEntity.noContent().build();
    }

}