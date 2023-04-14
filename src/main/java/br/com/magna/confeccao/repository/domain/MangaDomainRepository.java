package br.com.magna.confeccao.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.confeccao.entities.domain.partecima.MangaDomain;

public interface MangaDomainRepository extends JpaRepository<MangaDomain, Long> {

	@Query("""
			select m.manga from Manga m where (m.manga = :manga)
			""")
	String findyByManga(String manga);
	

	Boolean existsByManga(String manga);
	
}
