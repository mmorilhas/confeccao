package br.com.magna.confeccao.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.confeccao.entities.domain.modelagem.PregaDomain;

public interface PregaDomainRepository extends JpaRepository<PregaDomain, Long>{
	
	@Query("""
			select p.prega from Prega p where (p.prega = :prega)
			""")
	String findyByPrega(String prega);
	
	Boolean existsByPrega(String prega);

}
