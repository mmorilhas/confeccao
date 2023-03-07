package br.com.magna.confeccao.domain.tecido;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tecidos")
@Entity(name = "Tecido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tecido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)

	@JoinTable(name = "tecidos_composicao", joinColumns = { @JoinColumn(name = "tecido_id") }, inverseJoinColumns = {
			@JoinColumn(name = "fibras_id") })

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

	public Tecido(Construcao construcao, Collection<Fibra> composicao, String tipoTecido, String tempoSecagem,
			Boolean respiravel, String absorcaoAgua, String elasticidade, String comportamentoTermico,
			String resistencia) {
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
