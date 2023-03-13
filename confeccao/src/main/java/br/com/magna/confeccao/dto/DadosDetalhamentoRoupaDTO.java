package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.partecima.ParteDeCima;
import br.com.magna.confeccao.domain.roupa.Genero;
import br.com.magna.confeccao.domain.roupa.Roupa;
import br.com.magna.confeccao.domain.tecido.Tecido;

public record DadosDetalhamentoRoupaDTO(
	
		
		Long id,
		String nome,
		Integer tamanho,
		Genero genero,
		String cor,
		Boolean temEstampa,
		Boolean temBordado,
	    Modelagem modelagem,
		Tecido tecido,
		ParteDeCima parteDecima
	
		
		) {

	public DadosDetalhamentoRoupaDTO(Roupa roupa) {
		this(roupa.getId(),
				roupa.getNome(),
				roupa.getTamanho(),
				roupa.getGenero(),
				roupa.getCor(),
				roupa.getTemEstampa(),
				roupa.getTemBordado(),
				roupa.getModelagem(),
				roupa.getTecido(),
				roupa.getParteDeCima());
	}
	
}
