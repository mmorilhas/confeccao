package br.com.magna.confeccao.domain.roupa;

import org.hibernate.validator.constraints.Range;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.partecima.ParteDeCima;
import br.com.magna.confeccao.domain.tecido.Tecido;
import jakarta.persistence.CascadeType;
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


@Table(name = "roupas")
@Entity (name = "Roupa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Roupa{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Range(min=10, max=70)
	private Integer tamanho;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	private String cor;
	
	private Boolean temEstampa;
	
	private Boolean temBordado;
	
	@Embedded
	private Modelagem modelagem;
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tecido_id")
	private Tecido tecido;
	
	@Embedded
	private ParteDeCima parteDeCima;

	private Boolean ativo;
	
	
	public void excluir() {
		this.ativo = false;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setTecido(Tecido tecido) {
		this.tecido = tecido;
	}

	public void setParteDeCima(ParteDeCima parteDeCima) {
		this.parteDeCima = parteDeCima;
	}

	public void setAtivo() {
		this.ativo = true;
	}

	public Long getId() {
		return id;
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

	public Tecido getTecido() {
		return tecido;
	}

	public ParteDeCima getParteDeCima() {
		return parteDeCima;
	}




	
	
	
}
