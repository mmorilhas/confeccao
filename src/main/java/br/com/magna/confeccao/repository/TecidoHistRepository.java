package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.entities.tecido.TecidoHistorico;

public interface TecidoHistRepository extends JpaRepository<TecidoHistorico, Long>{

}
