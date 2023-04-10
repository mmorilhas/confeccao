package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.partecima.ComprimentoParteCima;

public record DadosListagemComprimentoDTO(Long id,
		String descricao
		
		) {
	
	public DadosListagemComprimentoDTO (ComprimentoParteCima comprimento) {
		this(comprimento.getId(), comprimento.getDescricao());
	}

}
