package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.modelagem.Silhueta;

public record DadosListagemSilhuetaDTO(
		
		Long id,
		String descricao
		
		) {
	
	public DadosListagemSilhuetaDTO(Silhueta silhueta) {
		this(silhueta.getId(), silhueta.getDescricao());
	}
}
