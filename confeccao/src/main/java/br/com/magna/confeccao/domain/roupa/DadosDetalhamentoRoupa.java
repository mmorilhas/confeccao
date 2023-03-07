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
	    Modelagem modelagem,
		Tecido tecido,
		Boolean temEstampa,
		Boolean temBordado,
		ParteDeCima parteDecima
	
		
		) {

	public DadosDetalhamentoRoupa(Roupa roupa) {
		this(roupa.getId(), roupa.getNome(), roupa.getTamanho(), roupa.getGenero(), roupa.getCor(), roupa.getModelagem(), roupa.getTecido(), roupa.getTemEstampa(), roupa.getTemBordado(), roupa.getParteDeCima());
	}
	
}
