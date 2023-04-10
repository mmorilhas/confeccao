package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.tecido.Tecido;

public record DadosListagemTecidoDTO(
		
		Long id,
		String tipoDeTecido,
		String tempoSecagem,
		Boolean respiravel,
		String absorcaoAgua,
		String elasticidade,
		String comportamentoTermico,
		String resistencia
		
		) {
	
	
	public DadosListagemTecidoDTO(Tecido tecido) {
		this(tecido.getId(),
				tecido.getTipoDeTecido(),
				tecido.getTempoSecagem(),
				tecido.getRespiravel(),
				tecido.getAbsorcaoAgua(),
				tecido.getElasticidade(),
				tecido.getComportamentoTermico(),
				tecido.getResistencia());
	}
	

}
