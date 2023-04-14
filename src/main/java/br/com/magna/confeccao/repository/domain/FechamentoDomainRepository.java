package br.com.magna.confeccao.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.confeccao.entities.domain.modelagem.FechamentoDomain;

public interface FechamentoDomainRepository extends JpaRepository<FechamentoDomain, Long>{

	@Query("""
			select f.fechamento from Fechamento f where (f.fechamento = :fechamento)
			""")
	String findyByFechamento(String fechamento);
	

	Boolean existsByFechamento(String fechamento);
	
}
