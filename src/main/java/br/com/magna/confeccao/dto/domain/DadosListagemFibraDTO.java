package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.fibra.FibraDomain;

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
	
	public DadosListagemFibraDTO(FibraDomain fibra) {
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
