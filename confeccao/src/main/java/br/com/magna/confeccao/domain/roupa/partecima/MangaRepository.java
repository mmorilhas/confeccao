package br.com.magna.confeccao.domain.roupa.partecima;

import org.springframework.data.jpa.repository.JpaRepository;

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
