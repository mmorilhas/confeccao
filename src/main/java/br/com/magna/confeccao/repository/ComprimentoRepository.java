package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.entities.domain.partecima.ComprimentoParteCimaDomain;

public interface ComprimentoRepository extends JpaRepository<ComprimentoParteCimaDomain, Long> {

		
	
}
