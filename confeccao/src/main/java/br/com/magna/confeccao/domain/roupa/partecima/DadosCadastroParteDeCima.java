package br.com.magna.confeccao.domain.roupa.partecima;

import br.com.magna.confeccao.domain.roupa.DadosCadastroRoupa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroParteDeCima(
		
		@NotNull @Valid DadosCadastroRoupa roupa,
		@NotNull Long idManga,
		@NotNull Long idDecote,
		@NotNull String cava,
		@NotNull Boolean capuz
		
		
		
		
		) {

	
	
}
