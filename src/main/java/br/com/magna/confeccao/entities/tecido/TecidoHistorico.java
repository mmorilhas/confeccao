package br.com.magna.confeccao.entities.tecido;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.magna.confeccao.entities.AbstractEntity;
import br.com.magna.confeccao.entities.domain.fibra.FibraDomain;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Table(name = "TB_HIST_TECIDO")
@Entity(name = "TecidoHistorico")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TecidoHistorico extends AbstractEntity<TecidoHistorico, Long>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_TECIDO")
	private Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TB_HIST_TECIDO_FIBRA_COMPOSICAO", joinColumns = {
			@JoinColumn(name = "FK_ID_TECIDO") }, inverseJoinColumns = { @JoinColumn(name = "FK_ID_FIBRA") })
	private Collection<FibraDomain> composicao;

	@Enumerated(EnumType.STRING)
	@Column(name = "VAR_CONSTRUCAO_TECIDO")
	private ConstrucaoEnum construcao;

	@Column(name = "VAR_TIPO_TECIDO")
	private String tipoDeTecido;

	@Column(name = "VAR_TEMPO_SECAGEM_TECIDO")
	private String tempoSecagem;

	@Column(name = "BOOL_RESPIRAVEL_TECIDO")
	private Boolean respiravel;

	@Column(name = "VAR_ABSORCAO_AGUA_TECIDO")
	private String absorcaoAgua;

	@Column(name = "VAR_ELASTICIDADE_TECIDO")
	private String elasticidade;

	@Column(name = "VAR_COMPORTAMENTO_TERMICO_TECIDO")
	private String comportamentoTermico;

	@Column(name = "VAR_RESISTENCIA_TECIDO")
	private String resistencia;

	public void setComposicao(Collection<FibraDomain> composicao) {
		this.composicao = composicao;
	}

	public void setConstrucao(ConstrucaoEnum construcao) {
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


	public Collection<FibraDomain> getComposicao() {
		return composicao;
	}

	public ConstrucaoEnum getConstrucao() {
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

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	
	


}
