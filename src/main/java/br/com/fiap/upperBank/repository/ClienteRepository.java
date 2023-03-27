package br.com.fiap.upperBank.repository;

import br.com.fiap.upperBank.models.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findBycpf(String cpf);
}
