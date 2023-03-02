package br.com.magna.confeccao.domain.roupa.partecima;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.roupa.DadosCadastroRoupa;
import br.com.magna.confeccao.domain.roupa.Genero;
import br.com.magna.confeccao.domain.roupa.Roupa;
import br.com.magna.confeccao.domain.tecido.Tecido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "parte_de_cima")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper=false)
public class ParteDeCima extends Roupa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "manga_id")
	private Manga manga;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "decote_id")
	private Decote decote;
	
	private String cava;
	
	private Boolean capuz;
	
	
	public ParteDeCima(DadosCadastroParteDeCima dados, DadosCadastroRoupa roupa, Modelagem modelagem, Tecido tecido,
			Manga manga, Decote decote) {
		super.nome = dados.roupa().nome();
		super.tamanho = dados.roupa().tamanho();
		super.genero = dados.roupa().genero();
		super.cor = dados.roupa().cor();
		super.modelagem = modelagem;
		super.temEstampa = dados.roupa().temEstampa();
		super.temBordado = dados.roupa().temBordado();
		super.tecido = tecido;
		this.manga = manga;
		this.decote = decote;
		this.cava = dados.cava();
		this.capuz = dados.capuz();
	}
	
	
	
}
