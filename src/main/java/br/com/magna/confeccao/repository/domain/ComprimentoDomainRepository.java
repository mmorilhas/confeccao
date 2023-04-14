package br.com.magna.confeccao.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.confeccao.entities.domain.partecima.ComprimentoDomain;

public interface ComprimentoDomainRepository extends JpaRepository<ComprimentoDomain, Long> {

	@Query("""
			select c.comprimento from Comprimento c where (c.comprimento = :comprimento)
			""")
	String findyByComprimento(String comprimento);
	
	

	Boolean existsByComprimento(String comprimento);
	
}
