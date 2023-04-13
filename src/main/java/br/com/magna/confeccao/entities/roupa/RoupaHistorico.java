package br.com.magna.confeccao.entities.roupa;

import org.hibernate.validator.constraints.Range;

import br.com.magna.confeccao.entities.AbstractEntity;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.entities.modelagem.Modelagem;
import br.com.magna.confeccao.entities.partecima.ParteDeCima;
import br.com.magna.confeccao.entities.roupa.enums.Genero;
import br.com.magna.confeccao.entities.tecido.Tecido;
import br.com.magna.confeccao.entities.tecido.TecidoHistorico;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Table(name = "TB_HIST_ROUPA")
@Entity (name = "RoupaHistorico")
@Inheritance(strategy = InheritanceType.JOINED)
public class RoupaHistorico extends AbstractEntity<RoupaHistorico, Long>{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PK_ID_ROUPA")
	private Long id;
	
	@NotBlank
	@Column(name="VAR_NOME_ROUPA")
	private String nome;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_TIPO_ROUPA")
	private TipoRoupaDomain tipoRoupa;
	
	@Range(min=10, max=70)
	@Column(name="INT_TAMANHO_ROUPA")
	private Integer tamanho;
	
	@Enumerated(EnumType.STRING)
	@Column(name="VAR_GENERO_ROUPA")
	private Genero genero;
	
	@Column(name="VAR_COR_ROUPA")
	private String cor;
	
	@Column(name="BOOL_ESTAMPA_ROUPA")
	private Boolean temEstampa;
	
	@Column(name="BOOL_BORDADO_ROUPA")
	private Boolean temBordado;
	
	@Embedded
	private Modelagem modelagem;
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_TECIDO")
	private TecidoHistorico tecido;
	
	@Embedded
	private ParteDeCima parteDeCima;

	@Column(name="BOOL_ATIVO")
	private Boolean ativo;
	
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void excluir() {
		this.ativo = false;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	public TipoRoupaDomain getTipoRoupa() {
		return tipoRoupa;
	}

	public void setTipoRoupa(TipoRoupaDomain tipoRoupa) {
		this.tipoRoupa = tipoRoupa;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setTemEstampa(Boolean temEstampa) {
		this.temEstampa = temEstampa;
	}

	public void setTemBordado(Boolean temBordado) {
		this.temBordado = temBordado;
	}

	public void setModelagem(Modelagem modelagem) {
		this.modelagem = modelagem;
	}

	public void setTecido(TecidoHistorico tecido) {
		this.tecido = tecido;
	}

	public void setParteDeCima(ParteDeCima parteDeCima) {
		this.parteDeCima = parteDeCima;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public Genero getGenero() {
		return genero;
	}

	public String getCor() {
		return cor;
	}

	public Boolean getTemEstampa() {
		return temEstampa;
	}

	public Boolean getTemBordado() {
		return temBordado;
	}

	public Modelagem getModelagem() {
		return modelagem;
	}

	public TecidoHistorico getTecido() {
		return tecido;
	}

	public ParteDeCima getParteDeCima() {
		return parteDeCima;
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
