package br.com.magna.confeccao.domain.roupa.partecima;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.roupa.Genero;
import br.com.magna.confeccao.domain.tecido.Tecido;

public record DadosListagemParteDeCima(
		
		Long id,
		String nome,
		Integer tamanho,
		Genero genero,
		String cor,
	    Modelagem modelagem,
		Tecido tecido,
		Boolean temEstampa,
		Boolean temBordado,
		Manga manga,
		Decote decote,
		String cava,
		Boolean capuz
		
		
		) {
	
	public DadosListagemParteDeCima(ParteDeCima p) {
		this(p.getId(), p.getNome(), p.getTamanho(), p.getGenero(), p.getCor(), p.getModelagem(), p.getTecido(),p.getTemEstampa(), p.getTemBordado(), p.getManga(), p.getDecote(), p.getCava(), p.getCapuz());
	}

}
