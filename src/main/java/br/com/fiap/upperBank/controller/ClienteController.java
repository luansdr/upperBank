package br.com.fiap.upperBank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @Autowired
    private ContaRepository contaRepository;
    

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }


    @GetMapping("/{id}/contas")
    public List<Conta> getContas(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return contaRepository.findByClienteId(id);
    }
}
