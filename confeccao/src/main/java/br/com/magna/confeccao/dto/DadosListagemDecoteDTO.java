package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.partecima.Decote;

public record DadosListagemDecoteDTO(


		Long id,
		String descricao
		
		) {
	
	public DadosListagemDecoteDTO(Decote decote) {
		this(decote.getId(), decote.getDescricao());
	}

	
}
