package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.partecima.Cava;

public record DadosListagemCavaDTO(Long id, String descricao

) {

	public DadosListagemCavaDTO(Cava cava) {
		this(cava.getId(), cava.getDescricao());
	}
}
