package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.partecima.CavaDomain;

public record DadosListagemCavaDTO(Long id, String descricao

) {

	public DadosListagemCavaDTO(CavaDomain cava) {
		this(cava.getId(), cava.getDescricaoCava());
	}
}
