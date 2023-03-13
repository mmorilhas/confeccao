package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.modelagem.Prega;

public record DadosListagemPregaDTO(
		Long id,
		String descricao
		
		) {
	
	public DadosListagemPregaDTO(Prega prega) {
		this(prega.getId(), prega.getDescricao());
	}

}
