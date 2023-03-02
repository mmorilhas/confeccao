package br.com.magna.confeccao.domain.tecido;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.domain.roupa.Roupa;

public interface TecidoRepository extends JpaRepository<Tecido, Long>{

}
