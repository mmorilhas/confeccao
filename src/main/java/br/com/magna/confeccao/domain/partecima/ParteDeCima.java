package br.com.magna.confeccao.domain.partecima;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ParteDeCima{
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_MANGA")
	private Manga manga;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_DECOTE")
	private Decote decote;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_CAVA")
	private Cava cava;
	
	
	@Column(name="BOOL_CAPUZ_ROUPA")
	private Boolean capuz;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_COMPRIMENTO")
	private ComprimentoParteCima comprimento;

	public void setManga(Manga manga) {
		this.manga = manga;
	}

	public void setDecote(Decote decote) {
		this.decote = decote;
	}

	public void setCava(Cava cava) {
		this.cava = cava;
	}

	public void setCapuz(Boolean capuz) {
		this.capuz = capuz;
	}

	public void setComprimento(ComprimentoParteCima comprimento) {
		this.comprimento = comprimento;
	}

	public Manga getManga() {
		return manga;
	}

	public Decote getDecote() {
		return decote;
	}

	public Cava getCava() {
		return cava;
	}

	public Boolean getCapuz() {
		return capuz;
	}

	public ComprimentoParteCima getComprimento() {
		return comprimento;
	}
	
	
	
	
}
