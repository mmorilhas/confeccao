package br.com.magna.confeccao.domain.roupa;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.roupa.partecima.ParteDeCima;
import br.com.magna.confeccao.domain.tecido.Tecido;

public record DadosDetalhamentoRoupa(
	
		
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

	public DadosDetalhamentoRoupa(Roupa roupa) {
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
