package br.com.magna.confeccao.domain.tecido;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaTecido(
		
		@NotNull Long id,
		Long[] idDasFibras,
		Construcao construcao
				
		) {

	
	
}
