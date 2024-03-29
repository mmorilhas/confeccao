package br.com.magna.confeccao.entities.domain.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name= "TB_DOM_PREGA")
@Entity(name = "Prega")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PregaDomain {


		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="PK_ID_PREGA")
		private Long id;
		
		@Column(name="VAR_DESCRICAO_PREGA")
		private String prega;

		public Long getId() {
			return id;
		}

		public String getDescricaoPrega() {
			return prega;
		}
		
		
	
}
