package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.modelagem.Fechamento;

public record DadosListagemFechamentoDTO(
		
		Long id,
		String aviamento,
		String local
		) {

	public DadosListagemFechamentoDTO(Fechamento fechamento) {
		this(fechamento.getId(), fechamento.getAviamento(), fechamento.getLocal());
	}


}
