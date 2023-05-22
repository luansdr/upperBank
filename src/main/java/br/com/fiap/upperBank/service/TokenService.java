package br.com.fiap.upperBank.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.fiap.upperBank.models.Credencial;
import br.com.fiap.upperBank.models.Token;
import br.com.fiap.upperBank.models.Usuario;
import br.com.fiap.upperBank.repository.UsuarioRepository;
import jakarta.validation.Valid;

@Service
public class TokenService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // @Value("${jwt.secret}")
    // String secret;
    

    

    public Token generateToken(@Valid Credencial credencial) {
        Algorithm alg = Algorithm.HMAC256("eyJzdWIiOiJqb2FvQGZpYXAuY29tLmJyIiwiaXNzIjoiTWV1SnVsaXVzIiwiZXhwIjoxNjgzNTk1NTg4fQ");
        String token = JWT.create()
                    .withSubject(credencial.email())
                    .withIssuer("meuJulius")
                    .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                    .sign(alg)
                    ;
        return new Token(token, "JWT", "Bearer");
    }

    public Usuario getValidateUser(String token) {
        Algorithm alg = Algorithm.HMAC256("eyJzdWIiOiJqb2FvQGZpYXAuY29tLmJyIiwiaXNzIjoiTWV1SnVsaXVzIiwiZXhwIjoxNjgzNTk1NTg4fQ");
        var email = JWT.require(alg)
                    .withIssuer("meuJulius")
                    .build()
                    .verify(token)
                    .getSubject()
                    ;

        return usuarioRepository.findByEmail(email)
                    .orElseThrow(() -> new JWTVerificationException("Usuario invalido"));
    }


    
}
