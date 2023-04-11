package br.com.magna.confeccao.entities.domain.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name= "TB_DOM_BARRA")
@Entity(name = "Barra")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BarraDomain {


		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="PK_ID_BARRA")
		private Long id;
		
		@Column(name="VAR_DESCRICAO_BARRA")
		private String descricao;

		public Long getId() {
			return id;
		}

		public String getDescricao() {
			return descricao;
		}
		
		
	
}
