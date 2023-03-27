package br.com.fiap.upperBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.upperBank.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
