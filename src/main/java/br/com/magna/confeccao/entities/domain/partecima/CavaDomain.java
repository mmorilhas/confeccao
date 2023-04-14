package br.com.magna.confeccao.entities.domain.partecima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_DOM_CAVA")
@Entity(name = "Cava")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CavaDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID_CAVA")
	private Long id;

	@Column(name="VAR_DESCRICAO_CAVA")
	private String cava;

	public Long getId() {
		return id;
	}

	public String getDescricaoCava() {
		return cava;
	}
	
}
