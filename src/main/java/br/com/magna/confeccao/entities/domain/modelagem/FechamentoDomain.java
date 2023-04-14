package br.com.magna.confeccao.entities.domain.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="TB_DOM_FECHAMENTO")
@Entity(name="Fechamento")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FechamentoDomain {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID_FECHAMENTO")
	private Long id;
	
	@Column(name="VAR_DESCRICAO_FECHAMENTO")
	private String fechamento;
	

	public Long getId() {
		return id;
	}

	public String getDescricaoFechamento() {
		return fechamento;
	}
}
