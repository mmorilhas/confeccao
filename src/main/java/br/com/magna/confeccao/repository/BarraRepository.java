package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.entities.domain.modelagem.BarraDomain;

public interface BarraRepository extends JpaRepository<BarraDomain, Long>{

}
