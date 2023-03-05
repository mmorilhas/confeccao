package br.com.magna.confeccao.domain.tecido;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import br.com.magna.confeccao.domain.fibra.Fibra;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tecidos")
@Entity(name = "Tecido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tecido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	
	private Collection<Fibra> composicao = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private Construcao construcao;
	
	private String tipoDeTecido;
	private String tempoSecagem;
	private Boolean respiravel;
	private String absorcaoAgua;
	private String elasticidade;
	private String comportamentoTermico;
	private String resistencia;
	
	public Tecido(Construcao construcao, Collection<Fibra> composicao, String tipoTecido, String tempoSecagem, Boolean respiravel, String absorcaoAgua, String elasticidade, String comportamentoTermico, String resistencia) {
		this.construcao = construcao;
		this.composicao = composicao;
		this.tipoDeTecido = tipoTecido;
		this.tempoSecagem = tempoSecagem;
		this.respiravel = respiravel;
		this.absorcaoAgua = absorcaoAgua;
		this.elasticidade = elasticidade;
		this.comportamentoTermico = comportamentoTermico;
		this.resistencia = resistencia;
	}
	
	
	
	
}
