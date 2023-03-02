package br.com.magna.confeccao.domain.roupa;

import br.com.magna.confeccao.domain.modelagem.DadosCadastroModelagem;
import br.com.magna.confeccao.domain.tecido.DadosCadastroTecido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroRoupa(
		
		@NotBlank String nome,
		@NotNull Integer tamanho,
		@NotNull Genero genero,
		@NotBlank String cor,
		@NotNull @Valid DadosCadastroModelagem modelagem,
		@NotNull @Valid DadosCadastroTecido tecido,
		Boolean temEstampa,
		Boolean temBordado
	
		
		) {

	
	
}
