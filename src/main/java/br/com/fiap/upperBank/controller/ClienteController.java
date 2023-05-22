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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/cliente")
@Tag(name = "Cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    @Operation(summary = "Obter todos os clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes encontrada"),
            @ApiResponse(responseCode = "404", description = "Nenhum cliente encontrado")
    })
    public ResponseEntity<List<Cliente>> show() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter detalhes de um cliente pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    public ResponseEntity<Cliente> show(@PathVariable Long id) {

        var clientesEncontrada = clienteRepository.findById(getCliente(id).getId())
                .orElseThrow(() -> new RestNotFoundException("Cliente não encontrado"));

        return ResponseEntity.ok(clientesEncontrada);

    }

    @PostMapping
    @ResponseBody
    @Operation(summary = "Criar um novo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos, a validação falhou")
    })
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente) {

        Optional<Cliente> clienteExistente = clienteRepository.findBycpf(cliente.getCpf());

        if (clienteExistente.isPresent()) {
            return ResponseEntity.badRequest().body(new ErroResponseExceptions("CPF já cadastrado").getMessage());
        }

        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping
    @Operation(summary = "Atualizar um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente) {

        clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new RestNotFoundException("Cliente não encontrado"));

        clienteRepository.save(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    public ResponseEntity<Cliente> delete(@PathVariable Long id) {

        var clientesEncontrada = clienteRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Cliente não encontrado"));
        clienteRepository.delete(clientesEncontrada);

        return ResponseEntity.noContent().build();
    }


    private Cliente getCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
    }

}
