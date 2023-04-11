package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.modelagem.PregaDomain;

public record DadosListagemPregaDTO(
		Long id,
		String descricao
		
		) {
	
	public DadosListagemPregaDTO(PregaDomain prega) {
		this(prega.getId(), prega.getDescricao());
	}

}
