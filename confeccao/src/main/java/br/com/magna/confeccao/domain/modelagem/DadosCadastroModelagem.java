package br.com.magna.confeccao.domain.modelagem;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroModelagem(
		
		
		@NotNull Long idSilhueta, 
		Long idFechamento,
		
		Boolean cinto,
		Boolean passantes,
		
		@NotNull Boolean pences,
		Boolean pala,
		
		Long idPrega,
		
		Boolean babado,
		Boolean fenda,
		
		Integer bolsos,
		
		@NotNull Boolean forro,
		@NotNull Long idBarra
		
		
		) {


}
