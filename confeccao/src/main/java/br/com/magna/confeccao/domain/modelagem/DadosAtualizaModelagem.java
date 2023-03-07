package br.com.magna.confeccao.domain.modelagem;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaModelagem(
		
		@NotNull Long id,
		Long idSilhueta, 
		Long idFechamento,
		
		Boolean cinto,
		Boolean passantes,
		
		Boolean pences,
		Boolean pala,
		
		Long idPrega,
		
		Boolean babado,
		Boolean fenda,
		
		Integer bolsos,
		
		Boolean forro,
		Long idBarra
		
		
		) {


}
