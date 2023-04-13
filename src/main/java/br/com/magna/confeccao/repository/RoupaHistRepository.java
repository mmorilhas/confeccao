package br.com.magna.confeccao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.entities.roupa.RoupaHistorico;

public interface RoupaHistRepository extends JpaRepository<RoupaHistorico, Long>{

	Page<Roupa> findAllByAtivoTrue(Pageable paginacao);
}
