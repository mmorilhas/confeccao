package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.entities.domain.partecima.MangaDomain;

public interface MangaRepository extends JpaRepository<MangaDomain, Long> {

		
	
}
