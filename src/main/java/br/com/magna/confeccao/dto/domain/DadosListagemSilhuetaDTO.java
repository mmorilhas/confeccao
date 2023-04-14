package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.modelagem.SilhuetaDomain;

public record DadosListagemSilhuetaDTO(
		
		Long id,
		String descricao
		
		) {
	
	public DadosListagemSilhuetaDTO(SilhuetaDomain silhueta) {
		this(silhueta.getId(), silhueta.getDescricaoSilhueta());
	}
}
