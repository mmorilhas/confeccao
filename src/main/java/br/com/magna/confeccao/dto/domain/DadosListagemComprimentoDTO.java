package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.partecima.ComprimentoDomain;

public record DadosListagemComprimentoDTO(Long id,
		String descricao
		
		) {
	
	public DadosListagemComprimentoDTO (ComprimentoDomain comprimento) {
		this(comprimento.getId(), comprimento.getDescricaoComprimento());
	}

}
