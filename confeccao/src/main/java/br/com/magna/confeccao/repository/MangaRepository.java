package br.com.magna.confeccao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.confeccao.domain.partecima.Manga;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface MangaRepository extends JpaRepository<Manga, Long> {

		
	
}
