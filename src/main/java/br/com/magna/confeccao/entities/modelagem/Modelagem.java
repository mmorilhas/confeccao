package br.com.magna.confeccao.entities.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Positive;

@Embeddable
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Modelagem {

	@JoinColumn(name = "STR_SILHUETA")
	private String silhueta;
	
	@JoinColumn(name = "STR_FECHAMENTO")
	private String fechamento;
	
	@Column(name="BOOL_CINTO_ROUPA")
	private Boolean cinto;
	
	@Column(name="BOOL_PASSANTE_ROUPA")
	private Boolean passantes;
	
	@Column(name="BOOL_PENCE_ROUPA")
	private Boolean pences;
	
	@Column(name="BOOL_PALA_ROUPA")
	private Boolean pala;
	
	@JoinColumn(name = "STR_PREGA")
	private String prega;

	@Column(name="BOOL_BABADO_ROUPA")
	private Boolean babado;
	
	@Column(name="BOOL_FENDA_ROUPA")
	private Boolean fenda;
	
	@Positive
	@Column(name="INT_BOLSOS_ROUPA")
	private Integer bolsos;

	@Column(name="BOOL_FORRO_ROUPA")
	private Boolean forro;

	@JoinColumn(name = "STR_BARRA")
	private String barra;

	public void setSilhueta(String silhueta) {
		this.silhueta = silhueta;
	}

	public void setFechamento(String fechamento) {
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

	public void setPrega(String prega) {
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

	public void setBarra(String barra) {
		this.barra = barra;
	}

	public String getSilhueta() {
		return silhueta;
	}

	public String getFechamento() {
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

	public String getPrega() {
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

	public String getBarra() {
		return barra;
	}
	
	
	



	
}
