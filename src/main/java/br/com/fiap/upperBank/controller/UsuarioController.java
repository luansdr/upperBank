package br.com.fiap.upperBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.upperBank.models.Credencial;
import br.com.fiap.upperBank.models.Usuario;
import br.com.fiap.upperBank.repository.UsuarioRepository;
import br.com.fiap.upperBank.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Auth", description = "Endpoints para autenticação e registro de usuários")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @PostMapping("/api/registrar")
    @Operation(summary = "Registrar novo usuário", description = "Registra um novo usuário no sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos, a validação falhou")
    })
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid Usuario usuario){
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PostMapping("/api/login")
    @Operation(summary = "Realizar login", description = "Realiza o login de um usuário e retorna um token de acesso.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos, a validação falhou")
    })
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial){
        manager.authenticate(credencial.toAuthentication());

        var token = tokenService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }
}
