package br.com.magna.confeccao.entities.roupa;

import org.hibernate.validator.constraints.Range;

import br.com.magna.confeccao.entities.AbstractEntity;
import br.com.magna.confeccao.entities.modelagem.Modelagem;
import br.com.magna.confeccao.entities.partecima.ParteDeCima;
import br.com.magna.confeccao.entities.roupa.enums.Genero;
import br.com.magna.confeccao.entities.tecido.Tecido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Table(name = "TB_ROUPA")
@Entity(name = "Roupa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Roupa extends AbstractEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ID_ROUPA")
	private Long id;

	@NotBlank
	@Column(name = "VAR_NOME_ROUPA")
	private String nome;

	@NotBlank
	@Column(name = "VAR_COLECAO_ROUPA")
	private String colecao;

	@JoinColumn(name = "STR_TIPO_ROUPA")
	private String tipoRoupa;

	@Range(min = 10, max = 70)
	@Column(name = "INT_TAMANHO_INICIAL_ROUPA")
	private Integer tamanhoInicial;

	@Range(min = 10, max = 70)
	@Column(name = "INT_TAMANHO_FINAL_ROUPA")
	private Integer tamanhoFinal;

	@Enumerated(EnumType.STRING)
	@Column(name = "VAR_GENERO_ROUPA")
	private Genero genero;

	@Column(name = "VAR_COR_ROUPA")
	private String cor;

	@Column(name = "BOOL_ESTAMPA_ROUPA")
	private Boolean temEstampa;

	@Column(name = "BOOL_BORDADO_ROUPA")
	private Boolean temBordado;

	@Embedded
	private Modelagem modelagem;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_TECIDO")
	private Tecido tecido;

	@Embedded
	private ParteDeCima parteDeCima;

	@Column(name = "BOOL_ATIVO")
	private Boolean ativo;

	public void excluir() {
		this.ativo = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getColecao() {
		return colecao;
	}

	public void setColecao(String colecao) {
		this.colecao = colecao;
	}

	public String getTipoRoupa() {
		return tipoRoupa;
	}

	public void setTipoRoupa(String tipoRoupa) {
		this.tipoRoupa = tipoRoupa;
	}

	public Integer getTamanhoInicial() {
		return tamanhoInicial;
	}

	public void setTamanhoInicial(Integer tamanhoInicial) {
		this.tamanhoInicial = tamanhoInicial;
	}

	public Integer getTamanhoFinal() {
		return tamanhoFinal;
	}

	public void setTamanhoFinal(Integer tamanhoFinal) {
		this.tamanhoFinal = tamanhoFinal;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Boolean getTemEstampa() {
		return temEstampa;
	}

	public void setTemEstampa(Boolean temEstampa) {
		this.temEstampa = temEstampa;
	}

	public Boolean getTemBordado() {
		return temBordado;
	}

	public void setTemBordado(Boolean temBordado) {
		this.temBordado = temBordado;
	}

	public Modelagem getModelagem() {
		return modelagem;
	}

	public void setModelagem(Modelagem modelagem) {
		this.modelagem = modelagem;
	}

	public Tecido getTecido() {
		return tecido;
	}

	public void setTecido(Tecido tecido) {
		this.tecido = tecido;
	}

	public ParteDeCima getParteDeCima() {
		return parteDeCima;
	}

	public void setParteDeCima(ParteDeCima parteDeCima) {
		this.parteDeCima = parteDeCima;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo() {
		this.ativo = true;
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
