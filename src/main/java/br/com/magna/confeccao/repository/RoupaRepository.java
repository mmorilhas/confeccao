package br.com.magna.confeccao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.entities.roupa.Roupa;

public interface RoupaRepository extends JpaRepository<Roupa, Long>{

	Page<Roupa> findAllByAtivoTrue(Pageable paginacao);
}
