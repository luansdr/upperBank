package br.com.fiap.upperBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.upperBank.models.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}
