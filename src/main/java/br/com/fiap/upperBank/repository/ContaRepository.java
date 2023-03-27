package br.com.fiap.upperBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.upperBank.models.Cliente;
import br.com.fiap.upperBank.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    Conta findByNumero(String numeroConta);
    List<Conta> findByCliente(Cliente cliente);
    @Query("SELECT c FROM Conta c JOIN c.cliente cl WHERE cl.id = :idCliente")
    List<Conta> findByClienteId(@Param("idCliente") Long idCliente);
}
