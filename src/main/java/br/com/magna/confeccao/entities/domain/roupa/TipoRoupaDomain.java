package br.com.magna.confeccao.entities.domain.roupa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Table(name= "TB_DOM_TIPO_ROUPA")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoRoupaDomain {
	
	
	@Id
	@Column(name="PK_VAR_TIPO_ROUPA")
	private String tipoRoupa;

	public String getTipoRoupa() {
		return tipoRoupa;
	}

	public void setTipoRoupa(String tipoRoupa) {
		this.tipoRoupa = tipoRoupa;
	}



}
