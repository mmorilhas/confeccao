package br.com.magna.confeccao.domain.partecima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name= "mangas")
@Entity(name = "Manga")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Manga {

		
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String comprimento;
		
		private String tipo;

		public Long getId() {
			return id;
		}

		public String getComprimento() {
			return comprimento;
		}

		public String getTipo() {
			return tipo;
		}
		
		

}
