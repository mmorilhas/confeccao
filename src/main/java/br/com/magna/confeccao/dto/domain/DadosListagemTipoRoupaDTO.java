package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;

public record DadosListagemTipoRoupaDTO(
		
		Long id,
		String tipoRoupa

) {

	public DadosListagemTipoRoupaDTO(TipoRoupaDomain tipoRoupa) {
		this(tipoRoupa.getId(), tipoRoupa.getDescricaoTipoRoupa());
	}
	
}
