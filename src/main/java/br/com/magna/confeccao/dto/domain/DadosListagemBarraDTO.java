package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.modelagem.BarraDomain;

public record DadosListagemBarraDTO(
		
		Long id,
		String descricao
		) {
	
	
	public DadosListagemBarraDTO(BarraDomain barra) {
		this(barra.getId(), barra.getDescricao());
	}

}
