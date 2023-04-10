package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.domain.partecima.ComprimentoParteCima;

public interface ComprimentoRepository extends JpaRepository<ComprimentoParteCima, Long> {

		
	
}
