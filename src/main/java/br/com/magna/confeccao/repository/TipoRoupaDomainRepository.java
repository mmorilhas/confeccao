package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;

public interface TipoRoupaDomainRepository extends JpaRepository<TipoRoupaDomain, String> {

	@Query("""
			SELECT t FROM TipoRoupaDomain t 
			WHERE (t.tipoRoupa = :tipoRoupa)
			""")
	TipoRoupaDomain findByTipoRoupa(String tipoRoupa);

}
