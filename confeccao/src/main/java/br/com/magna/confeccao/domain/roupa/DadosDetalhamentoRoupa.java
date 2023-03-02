package br.com.magna.confeccao.domain.roupa;

import br.com.magna.confeccao.domain.modelagem.DadosDetalhamentoModelagem;
import br.com.magna.confeccao.domain.tecido.DadosDetalhamentoTecido;

public record DadosDetalhamentoRoupa(
		
		String nome,
		Integer tamanho,
		Genero genero,
		String cor,
	    DadosDetalhamentoModelagem modelagem,
		DadosDetalhamentoTecido tecido,
		Boolean temEstampa,
		Boolean temBordado
	
		
		) {

	
}
