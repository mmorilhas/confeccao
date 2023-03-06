package br.com.magna.confeccao.domain.roupa.partecima;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroParteDeCima(
		
		@NotNull Long idManga,
		@NotNull Long idDecote,
		@NotNull String cava,
		@NotNull Boolean capuz
		
		
		
		
		) {

	
	
}
