package br.com.magna.confeccao.domain.roupa.partecima;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	
	
}
