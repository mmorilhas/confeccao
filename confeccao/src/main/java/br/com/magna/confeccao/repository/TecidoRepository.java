package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.domain.roupa.Roupa;
import br.com.magna.confeccao.domain.tecido.Tecido;

public interface TecidoRepository extends JpaRepository<Tecido, Long>{

}
