package br.com.magna.confeccao.domain.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;

@Embeddable
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Modelagem {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "silhueta_id")
	private Silhueta silhueta;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fechamento_id")
	private Fechamento fechamento;
	
	private Boolean cinto;
	private Boolean passantes;
	
	private Boolean pences;
	
	private Boolean pala;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "prega_id")
	private Prega prega;

	private Boolean babado;
	
	private Boolean fenda;
	
	@Positive
	private Integer bolsos;

	private Boolean forro;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "barra_id")
	private Barra barra;

	public void setSilhueta(Silhueta silhueta) {
		this.silhueta = silhueta;
	}

	public void setFechamento(Fechamento fechamento) {
		this.fechamento = fechamento;
	}

	public void setCinto(Boolean cinto) {
		this.cinto = cinto;
	}

	public void setPassantes(Boolean passantes) {
		this.passantes = passantes;
	}

	public void setPences(Boolean pences) {
		this.pences = pences;
	}

	public void setPala(Boolean pala) {
		this.pala = pala;
	}

	public void setPrega(Prega prega) {
		this.prega = prega;
	}

	public void setBabado(Boolean babado) {
		this.babado = babado;
	}

	public void setFenda(Boolean fenda) {
		this.fenda = fenda;
	}

	public void setBolsos(Integer bolsos) {
		this.bolsos = bolsos;
	}

	public void setForro(Boolean forro) {
		this.forro = forro;
	}

	public void setBarra(Barra barra) {
		this.barra = barra;
	}

	public Silhueta getSilhueta() {
		return silhueta;
	}

	public Fechamento getFechamento() {
		return fechamento;
	}

	public Boolean getCinto() {
		return cinto;
	}

	public Boolean getPassantes() {
		return passantes;
	}

	public Boolean getPences() {
		return pences;
	}

	public Boolean getPala() {
		return pala;
	}

	public Prega getPrega() {
		return prega;
	}

	public Boolean getBabado() {
		return babado;
	}

	public Boolean getFenda() {
		return fenda;
	}

	public Integer getBolsos() {
		return bolsos;
	}

	public Boolean getForro() {
		return forro;
	}

	public Barra getBarra() {
		return barra;
	}
	
	
	



	
}
