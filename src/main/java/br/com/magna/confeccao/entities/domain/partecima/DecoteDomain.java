package br.com.magna.confeccao.entities.domain.partecima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name= "TB_DOM_DECOTE")
@Entity(name = "Decote")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DecoteDomain {

		
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="PK_ID_DECOTE")
		private Long id;
		
		@Column(name="VAR_DESCRICAO_DECOTE")
		private String descricao;

		public Long getId() {
			return id;
		}

		public String getDescricao() {
			return descricao;
		}
		
		
		

}
