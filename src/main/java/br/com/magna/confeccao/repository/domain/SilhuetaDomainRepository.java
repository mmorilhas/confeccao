package br.com.magna.confeccao.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.confeccao.entities.domain.modelagem.SilhuetaDomain;

public interface SilhuetaDomainRepository extends JpaRepository<SilhuetaDomain, Long>{
	
	@Query("""
			select s.silhueta from Silhueta s where (s.silhueta = :silhueta)
			""")
	String findyBySilhueta(String silhueta);
	
	

	Boolean existsBySilhueta(String silhueta);

}
