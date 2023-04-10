package br.com.magna.confeccao.domain.partecima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name= "TB_DOM_COMPRIMENTO")
@Entity(name = "ComprimentoParteCima")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ComprimentoParteCima {
		
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="PK_ID_COMPRIMENTO")
		private Long id;
		
		@Column(name="VAR_DESCRICAO_COMPRIMENTO")
		private String descricao;

		public Long getId() {
			return id;
		}

		public String getDescricao() {
			return descricao;
		}
		
		

}