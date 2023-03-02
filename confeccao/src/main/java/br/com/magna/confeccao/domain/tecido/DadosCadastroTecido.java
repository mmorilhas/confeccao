package br.com.magna.confeccao.domain.tecido;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroTecido(
		
		@NotNull Long[] idDasFibras,
		@NotNull Construcao construcao
				
		) {

	
	
}
