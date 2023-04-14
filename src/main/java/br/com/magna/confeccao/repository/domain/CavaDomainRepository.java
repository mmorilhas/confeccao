package br.com.magna.confeccao.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.confeccao.entities.domain.partecima.CavaDomain;

public interface CavaDomainRepository extends JpaRepository<CavaDomain, Long> {

	@Query("""
			select c.cava from Cava c where (c.cava = :cava)
			""")
	String findyByCava(String cava);
	

	Boolean existsByCava(String cava);
	
}
