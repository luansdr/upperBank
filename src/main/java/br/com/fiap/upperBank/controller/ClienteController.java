package br.com.fiap.upperBank.controller;
import java.util.Calendar;

import org.springframework.web.bind.annotation.*;

import br.com.fiap.upperBank.models.Cliente;

@RestController
public class ClienteController {

    @GetMapping("/api/cliente")
    public Cliente show(){
        var cliente = new Cliente("40587128801", "Luan Reis", Calendar.getInstance());
        return cliente;
    }
}