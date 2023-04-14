package br.com.magna.confeccao.entities.domain.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name= "TB_DOM_SILHUETA")
@Entity(name = "Silhueta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SilhuetaDomain {


		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="PK_ID_SILHUETA")
		private Long id;
		
		@Column(name="VAR_DESCRICAO_SILHUETA")
		private String silhueta;

		public Long getId() {
			return id;
		}

		public String getDescricaoSilhueta() {
			return silhueta;
		}
		
		
	
}
