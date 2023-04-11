package br.com.magna.confeccao.entities.partecima;

import br.com.magna.confeccao.entities.domain.partecima.CavaDomain;
import br.com.magna.confeccao.entities.domain.partecima.ComprimentoParteCimaDomain;
import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;
import br.com.magna.confeccao.entities.domain.partecima.MangaDomain;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ParteDeCima{
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_MANGA")
	private MangaDomain manga;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_DECOTE")
	private DecoteDomain decote;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_CAVA")
	private CavaDomain cava;
	
	
	@Column(name="BOOL_CAPUZ_ROUPA")
	private Boolean capuz;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_ID_COMPRIMENTO")
	private ComprimentoParteCimaDomain comprimento;

	public void setManga(MangaDomain manga) {
		this.manga = manga;
	}

	public void setDecote(DecoteDomain decote) {
		this.decote = decote;
	}

	public void setCava(CavaDomain cava) {
		this.cava = cava;
	}

	public void setCapuz(Boolean capuz) {
		this.capuz = capuz;
	}

	public void setComprimento(ComprimentoParteCimaDomain comprimento) {
		this.comprimento = comprimento;
	}

	public MangaDomain getManga() {
		return manga;
	}

	public DecoteDomain getDecote() {
		return decote;
	}

	public CavaDomain getCava() {
		return cava;
	}

	public Boolean getCapuz() {
		return capuz;
	}

	public ComprimentoParteCimaDomain getComprimento() {
		return comprimento;
	}
	
	
	
	
}
