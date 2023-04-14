package br.com.magna.confeccao.entities.partecima;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;

@Embeddable
public class ParteDeCima{
	
	@JoinColumn(name = "STR_MANGA")
	private String manga;
	
	@JoinColumn(name = "STR_DECOTE")
	private String decote;
	
	@JoinColumn(name = "STR_CAVA")
	private String cava;
	
	
	@Column(name="BOOL_CAPUZ_ROUPA")
	private Boolean capuz;
	
	@JoinColumn(name = "STR_COMPRIMENTO")
	private String comprimento;

	public void setManga(String manga) {
		this.manga = manga;
	}

	public void setDecote(String decote) {
		this.decote = decote;
	}

	public void setCava(String cava) {
		this.cava = cava;
	}

	public void setCapuz(Boolean capuz) {
		this.capuz = capuz;
	}

	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}

	public String getManga() {
		return manga;
	}

	public String getDecote() {
		return decote;
	}

	public String getCava() {
		return cava;
	}

	public Boolean getCapuz() {
		return capuz;
	}

	public String getComprimento() {
		return comprimento;
	}
	
	
	
	
}
