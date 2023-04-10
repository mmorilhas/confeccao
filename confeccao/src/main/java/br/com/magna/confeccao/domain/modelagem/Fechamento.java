package br.com.magna.confeccao.domain.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name= "TB_DOM_FECHAMENTO")
@Entity(name = "Fechamento")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fechamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID_FECHAMENTO")
	private Long id;
	
	@Column(name="VAR_AVIAMENTO_FECHAMENTO")
	private String aviamento;
	
	@Column(name="VAR_LOCAL_FECHAMENTO")
	private String local;

	public Long getId() {
		return id;
	}

	public String getAviamento() {
		return aviamento;
	}

	public String getLocal() {
		return local;
	}
	
	
}
