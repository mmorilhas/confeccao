package br.com.magna.confeccao.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaModelagemDTO(
		
		@NotNull Long idSilhueta, 
		@NotNull Long idFechamento,
		
		@NotNull Boolean cinto,
		@NotNull Boolean passantes,
		
		@NotNull Boolean pences,
		@NotNull Boolean pala,
		
		@NotNull Long idPrega,
		
		@NotNull Boolean babado,
		@NotNull Boolean fenda,
		
		@NotNull Integer bolsos,
		
		@NotNull Boolean forro,
		@NotNull Long idBarra
		
		
		) {


}
