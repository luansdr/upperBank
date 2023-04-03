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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.upperBank.exceptions.ErroResponseExceptions;
import br.com.fiap.upperBank.exceptions.RestNotFoundException;
import br.com.fiap.upperBank.models.Cliente;
import br.com.fiap.upperBank.repository.ClienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Cliente>> show() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.ok(clientes);
    }

    // GET DETAILS
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> show(@PathVariable Long id) {

        var clientesEncontrada = clienteRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Cliente não encontrado"));
        ;

        return ResponseEntity.ok(clientesEncontrada);

    }

    // POST
    @ResponseBody
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente) {

        Optional<Cliente> clienteExistente = clienteRepository.findBycpf(cliente.getCpf());

        if (clienteExistente.isPresent()) {
            return ResponseEntity.badRequest().body(new ErroResponseExceptions("CPF já cadastrado").getMessage());
        }

        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    // PUT
    @PutMapping
    public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente) {

        clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new RestNotFoundException("Cliente não encontrado"));

        clienteRepository.save(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id) {

        var clientesEncontrada = clienteRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Cliente não encontrado"));
        ;
        clienteRepository.delete(clientesEncontrada);

        return ResponseEntity.noContent().build();
    }

}
