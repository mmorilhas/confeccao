package br.com.magna.confeccao.dto;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroModelagemDTO(
		
		
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
