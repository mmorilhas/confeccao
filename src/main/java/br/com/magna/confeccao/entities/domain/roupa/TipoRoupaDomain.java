package br.com.magna.confeccao.entities.domain.roupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name= "TB_DOM_TIPO_ROUPA")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoRoupaDomain {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID_TIPO_ROUPA")
	private Long id;
	
	@Column(name="VAR_DESCRICAO_TIPO_ROUPA")
	private String tipoRoupa;

	public String getDescricaoTipoRoupa() {
		return tipoRoupa;
	}

	public void setTipoRoupa(String tipoRoupa) {
		this.tipoRoupa = tipoRoupa;
	}

	public Long getId() {
		return id;
	}



}
