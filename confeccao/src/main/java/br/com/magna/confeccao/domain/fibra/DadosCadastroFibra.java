package br.com.magna.confeccao.domain.fibra;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFibra(
		
		@NotBlank String nomeFibra,
		@NotNull String tipoFibra, 
		@NotNull String tempoSecagem,
		@NotNull String respiravel,
		@NotNull String absorcaoAgua,
		@NotNull String elasticidade,
		@NotNull String comportamentoTermico,
		@NotNull String resistencia
		
		
		
		
		) {

	
	
}
