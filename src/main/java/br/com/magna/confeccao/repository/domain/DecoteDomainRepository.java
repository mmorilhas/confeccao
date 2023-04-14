package br.com.magna.confeccao.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;

public interface DecoteDomainRepository extends JpaRepository<DecoteDomain, Long> {

	@Query("""
			select d.decote from Decote d where (d.decote = :decote)
			""")
	String findyByDecote(String decote);
	
	

	Boolean existsByDecote(String decote);
	
}
