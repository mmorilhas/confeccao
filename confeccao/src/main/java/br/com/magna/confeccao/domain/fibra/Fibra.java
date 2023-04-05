package br.com.magna.confeccao.domain.fibra;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "fibras")
@Entity
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id") 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fibra {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nomeFibra;
	
	private String tipoFibra;
	
	private String tempoSecagem;
	private Boolean respiravel;
	private String absorcaoAgua;
	private String elasticidade;
	private String comportamentoTermico;
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
