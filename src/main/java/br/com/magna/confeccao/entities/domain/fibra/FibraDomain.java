package br.com.magna.confeccao.entities.domain.fibra;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "TB_FIBRA")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FibraDomain {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID_FIBRA")
	private Long id;
	
	@Column(unique = true, name="VAR_NOME_FIBRA")
	private String nomeFibra;
	
	@Column(name="VAR_TIPO_FIBRA")
	private String tipoFibra;
	
	@Column(name="VAR_TEMPO_SECAGEM_FIBRA")
	private String tempoSecagem;
	
	@Column(name="BOOL_RESPIRAVEL_FIBRA")
	private Boolean respiravel;
	
	@Column(name="VAR_ABSORCAO_AGUA_FIBRA")
	private String absorcaoAgua;
	
	@Column(name="VAR_ELASTICIDADE_FIBRA")
	private String elasticidade;
	
	@Column(name="VAR_COMPORTAMENTO_TERMICO_FIBRA")
	private String comportamentoTermico;
	
	@Column(name="VAR_RESISTENCIA_FIBRA")
	private String resistencia;
	
	public Long getId() {
		return id;
	}
	public String getNomeFibra() {
		return nomeFibra;
	}
	public String getTipoFibra() {
		return tipoFibra;
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
