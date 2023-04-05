package br.com.magna.confeccao.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaParteDeCimaDTO(
		
		@NotNull Long idManga,
		@NotNull Long idDecote,
		@NotNull Long idCava,
		@NotNull Boolean capuz,
		@NotNull Long idComprimento
		
		) {
	
}
