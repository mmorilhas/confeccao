package br.com.magna.confeccao.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;

public interface TipoRoupaDomainRepository extends JpaRepository<TipoRoupaDomain, String> {

	@Query("""
			select t.tipoRoupa from TipoRoupaDomain t 
			where t.tipoRoupa = :tipoRoupa
			""")
	String findByTipoRoupa(String tipoRoupa);
	
	
	Boolean existsByTipoRoupa(String tipoRoupa);

}
