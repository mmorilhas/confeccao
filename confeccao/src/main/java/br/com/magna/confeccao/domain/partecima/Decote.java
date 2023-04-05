package br.com.magna.confeccao.domain.partecima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name= "decotes")
@Entity(name = "Decote")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Decote {

		
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
