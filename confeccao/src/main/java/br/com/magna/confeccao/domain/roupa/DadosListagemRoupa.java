package br.com.magna.confeccao.domain.roupa;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.roupa.partecima.ParteDeCima;
import br.com.magna.confeccao.domain.tecido.DadosListagemTecido;
import br.com.magna.confeccao.domain.tecido.Tecido;

public record DadosListagemRoupa(
	
		
		Long id,
		String nome,
		Integer tamanho,
		Genero genero,
		String cor,
		Boolean temEstampa,
		Boolean temBordado,
	    Modelagem modelagem,
		ParteDeCima parteDecima,
		DadosListagemTecido tecido
	
		
		) {

	public DadosListagemRoupa(Roupa roupa) {
		this(roupa.getId(),
				roupa.getNome(), 
				roupa.getTamanho(),
				roupa.getGenero(),
				roupa.getCor(),
				roupa.getTemEstampa(),
				roupa.getTemBordado(),
				roupa.getModelagem(),
				roupa.getParteDeCima(),
				new DadosListagemTecido(roupa.getTecido()));
	}
	
}
