package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.modelagem.Barra;

public record DadosListagemBarraDTO(
		
		Long id,
		String descricao
		) {
	
	
	public DadosListagemBarraDTO(Barra barra) {
		this(barra.getId(), barra.getDescricao());
	}

}
