package br.com.magna.confeccao.domain.roupa.partecima;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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
	
	private String cava;
	
	private Boolean capuz;
	
	
	
}
