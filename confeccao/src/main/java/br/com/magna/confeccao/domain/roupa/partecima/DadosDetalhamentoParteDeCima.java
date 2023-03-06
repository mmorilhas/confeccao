package br.com.magna.confeccao.domain.roupa.partecima;

import br.com.magna.confeccao.domain.roupa.DadosListagemRoupa;

public record DadosDetalhamentoParteDeCima(
		
		DadosListagemRoupa roupa,
		Manga manga,
		Decote decote,
		String cava,
		Boolean capuz

		
		) {

	/*public DadosDetalhamentoParteDeCima(ParteDeCima p) {
		this(p.getId(), p.getNome(), p.getTamanho(), p.getGenero(), p.getCor(), p.getModelagem(), p.getTecido(), p.getTemEstampa(), p.getTemBordado(), p.getManga(), p.getDecote(), p.getCava(), p.getCapuz());*/
	



	
}
