package br.com.magna.confeccao.entities.domain.partecima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name= "TB_DOM_MANGA")
@Entity(name = "Manga")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MangaDomain {

		
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="PK_ID_MANGA")
		private Long id;
		
		@Column(name="VAR_DESCRICAO_MANGA")
		private String manga;
		

		public Long getId() {
			return id;
		}

		public String getDescricaoManga() {
			return manga;
		}

		
		

}
