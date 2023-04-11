package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.entities.tecido.Tecido;

public interface TecidoRepository extends JpaRepository<Tecido, Long>{

}
