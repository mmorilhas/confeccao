package br.com.magna.confeccao.domain.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name= "pregas")
@Entity(name = "Prega")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prega {


		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String descricao;

		public Long getId() {
			return id;
		}

		public String getDescricao() {
			return descricao;
		}
		
		
	
}
