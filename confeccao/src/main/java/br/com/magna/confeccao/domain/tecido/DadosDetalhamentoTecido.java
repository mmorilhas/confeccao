package br.com.magna.confeccao.domain.tecido;

import java.util.Collection;

import br.com.magna.confeccao.domain.fibra.Fibra;

public record DadosDetalhamentoTecido(
		
		Collection<Fibra> composicao,
		Construcao construcao,
		String tipoTecido,
		String tempoSecagem,
		Boolean respiravel,
		String absorcaoAgua,
		String elasticidade,
		String comportamentoTermico,
		String resistencia
				
		) {

	
	
}
