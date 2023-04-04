package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.partecima.ParteDeCima;
import br.com.magna.confeccao.domain.roupa.Genero;
import br.com.magna.confeccao.domain.roupa.Roupa;

public record DadosListagemRoupaDTO(
	
		
		Long id,
		String nome,
		Integer tamanho,
		Genero genero,
		String cor,
		Boolean temEstampa,
		Boolean temBordado,
	    Modelagem modelagem,
		ParteDeCima parteDecima,
		DadosListagemTecidoDTO tecido
	
		
		) {

	public DadosListagemRoupaDTO(Roupa roupa) {
		this(roupa.getId(),
				roupa.getNome(), 
				roupa.getTamanho(),
				roupa.getGenero(),
				roupa.getCor(),
				roupa.getTemEstampa(),
				roupa.getTemBordado(),
				roupa.getModelagem(),
				roupa.getParteDeCima(),
				new DadosListagemTecidoDTO(roupa.getTecido()));
	}
	
}
