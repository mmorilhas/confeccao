package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.modelagem.FechamentoDomain;

public record DadosListagemFechamentoDTO(
		
		Long id,
		String aviamento,
		String local
		) {

	public DadosListagemFechamentoDTO(FechamentoDomain fechamento) {
		this(fechamento.getId(), fechamento.getAviamento(), fechamento.getLocal());
	}


}
