package br.com.magna.confeccao.domain.tecido;

import java.util.Collection;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.magna.confeccao.domain.fibra.Fibra;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "tecidos")
@Entity(name = "Tecido")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tecido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tecidos_composicao", 
	joinColumns = { @JoinColumn(name = "tecido_id") },
	inverseJoinColumns = { @JoinColumn(name = "fibras_id") })
	private Collection<Fibra> composicao;

	@Enumerated(EnumType.STRING)
	private Construcao construcao;

	private String tipoDeTecido;
	private String tempoSecagem;
	private Boolean respiravel;
	private String absorcaoAgua;
	private String elasticidade;
	private String comportamentoTermico;
	private String resistencia;
	
	
	public void setComposicao(Collection<Fibra> composicao) {
		this.composicao = composicao;
	}
	public void setConstrucao(Construcao construcao) {
		this.construcao = construcao;
	}
	public void setTipoDeTecido(String tipoDeTecido) {
		this.tipoDeTecido = tipoDeTecido;
	}
	public void setTempoSecagem(String tempoSecagem) {
		this.tempoSecagem = tempoSecagem;
	}
	public void setRespiravel(Boolean respiravel) {
		this.respiravel = respiravel;
	}
	public void setAbsorcaoAgua(String absorcaoAgua) {
		this.absorcaoAgua = absorcaoAgua;
	}
	public void setElasticidade(String elasticidade) {
		this.elasticidade = elasticidade;
	}
	public void setComportamentoTermico(String comportamentoTermico) {
		this.comportamentoTermico = comportamentoTermico;
	}
	public void setResistencia(String resistencia) {
		this.resistencia = resistencia;
	}
	public Long getId() {
		return id;
	}
	public Collection<Fibra> getComposicao() {
		return composicao;
	}
	public Construcao getConstrucao() {
		return construcao;
	}
	public String getTipoDeTecido() {
		return tipoDeTecido;
	}
	public String getTempoSecagem() {
		return tempoSecagem;
	}
	public Boolean getRespiravel() {
		return respiravel;
	}
	public String getAbsorcaoAgua() {
		return absorcaoAgua;
	}
	public String getElasticidade() {
		return elasticidade;
	}
	public String getComportamentoTermico() {
		return comportamentoTermico;
	}
	public String getResistencia() {
		return resistencia;
	}
	
	
	
	


}
