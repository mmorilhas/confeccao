package br.com.magna.confeccao.entities.modelagem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.magna.confeccao.entities.domain.modelagem.BarraDomain;
import br.com.magna.confeccao.entities.domain.modelagem.FechamentoDomain;
import br.com.magna.confeccao.entities.domain.modelagem.PregaDomain;
import br.com.magna.confeccao.entities.domain.modelagem.SilhuetaDomain;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;

@Embeddable
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Modelagem {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_ID_SILHUETA")
	private SilhuetaDomain silhueta;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_FECHAMENTO")
	private FechamentoDomain fechamento;
	
	@Column(name="BOOL_CINTO_ROUPA")
	private Boolean cinto;
	
	@Column(name="BOOL_PASSANTE_ROUPA")
	private Boolean passantes;
	
	@Column(name="BOOL_PENCE_ROUPA")
	private Boolean pences;
	
	@Column(name="BOOL_PALA_ROUPA")
	private Boolean pala;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_PREGA")
	private PregaDomain prega;

	@Column(name="BOOL_BABADO_ROUPA")
	private Boolean babado;
	
	@Column(name="BOOL_FENDA_ROUPA")
	private Boolean fenda;
	
	@Positive
	@Column(name="INT_BOLSOS_ROUPA")
	private Integer bolsos;

	@Column(name="BOOL_FORRO_ROUPA")
	private Boolean forro;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_BARRA")
	private BarraDomain barra;

	public void setSilhueta(SilhuetaDomain silhueta) {
		this.silhueta = silhueta;
	}

	public void setFechamento(FechamentoDomain fechamento) {
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

	public void setPrega(PregaDomain prega) {
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

	public void setBarra(BarraDomain barra) {
		this.barra = barra;
	}

	public SilhuetaDomain getSilhueta() {
		return silhueta;
	}

	public FechamentoDomain getFechamento() {
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

	public PregaDomain getPrega() {
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

	public BarraDomain getBarra() {
		return barra;
	}
	
	
	



	
}
