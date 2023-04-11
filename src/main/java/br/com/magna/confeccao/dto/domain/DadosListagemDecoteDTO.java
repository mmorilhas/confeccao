package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;

public record DadosListagemDecoteDTO(


		Long id,
		String descricao
		
		) {
	
	public DadosListagemDecoteDTO(DecoteDomain decote) {
		this(decote.getId(), decote.getDescricao());
	}

	
}
