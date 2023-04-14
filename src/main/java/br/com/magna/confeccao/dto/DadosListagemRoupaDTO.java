package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.entities.modelagem.Modelagem;
import br.com.magna.confeccao.entities.partecima.ParteDeCima;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.entities.roupa.enums.Genero;

public record DadosListagemRoupaDTO(
	
		
		Long id,
		String nome,
		String tipoRoupa,
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
				roupa.getTipoRoupa(),
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
