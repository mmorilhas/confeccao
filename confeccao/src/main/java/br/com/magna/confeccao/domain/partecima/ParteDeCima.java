package br.com.magna.confeccao.domain.partecima;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//@Getter
//@NoArgsConstructor
@Embeddable
public class ParteDeCima{
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "manga_id")
	private Manga manga;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "decote_id")
	private Decote decote;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cava_id")
	private Cava cava;
	
	private Boolean capuz;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "comprimento_id")
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
	
	
	
	
}
