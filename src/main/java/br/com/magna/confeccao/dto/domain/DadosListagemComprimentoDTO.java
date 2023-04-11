package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.partecima.ComprimentoParteCimaDomain;

public record DadosListagemComprimentoDTO(Long id,
		String descricao
		
		) {
	
	public DadosListagemComprimentoDTO (ComprimentoParteCimaDomain comprimento) {
		this(comprimento.getId(), comprimento.getDescricao());
	}

}
