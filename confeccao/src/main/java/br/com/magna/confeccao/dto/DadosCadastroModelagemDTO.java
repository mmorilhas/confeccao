package br.com.magna.confeccao.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

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
		
		@Positive Integer bolsos,
		
		@NotNull Boolean forro,
		@NotNull Long idBarra
		
		
		) {


}
