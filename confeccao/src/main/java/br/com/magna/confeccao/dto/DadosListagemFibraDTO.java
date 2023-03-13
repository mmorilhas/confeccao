package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.fibra.Fibra;

public record DadosListagemFibraDTO(
		
		Long id,
		String nomeFibra,
		String tipoFibra,
		String tempoSecagem,
		Boolean respiravel,
		String absorcaoAgua,
		String elasticidade,
		String comportamentoTermico,
		String resistencia
		) {
	
	public DadosListagemFibraDTO(Fibra fibra) {
		this(fibra.getId(),
				fibra.getNomeFibra(),
				fibra.getTipoFibra(),
				fibra.getTempoSecagem(),
				fibra.getRespiravel(),
				fibra.getAbsorcaoAgua(),
				fibra.getElasticidade(),
				fibra.getComportamentoTermico(),
				fibra.getResistencia()
				);
		
	}

}
