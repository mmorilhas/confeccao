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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "roupas")
@Entity (name = "Roupa")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
	
	public Roupa(String nome, Integer tamanho, Genero genero, String cor, Boolean temEstampa, Boolean temBordado, Modelagem modelagem, Tecido tecido, ParteDeCima parteDeCima) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.genero = genero;
		this.cor = cor;
		this.temEstampa = temEstampa;
		this.temBordado = temBordado;
		this.modelagem = modelagem;
		this.tecido = tecido;
		this.parteDeCima = parteDeCima;
		this.ativo = true;
	}
	
	public void excluir() {
		this.ativo = false;
	}
	
	
	
}
