package br.com.magna.confeccao.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.confeccao.entities.domain.modelagem.BarraDomain;

public interface BarraDomainRepository extends JpaRepository<BarraDomain, Long>{

	
	@Query("""
			select b.barra from Barra b where (b.barra = :barra)
			""")
	String findyByBarra(String barra);
	
	

	Boolean existsByBarra(String barra);
	
}
