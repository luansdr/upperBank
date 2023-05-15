package br.com.fiap.upperBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.upperBank.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
