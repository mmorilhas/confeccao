package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.modelagem.FechamentoDomain;

public record DadosListagemFechamentoDTO(
		
		Long id,
		String fechamento
		) {

	public DadosListagemFechamentoDTO(FechamentoDomain fechamento) {
		this(fechamento.getId(), fechamento.getDescricaoFechamento());
	}


}
