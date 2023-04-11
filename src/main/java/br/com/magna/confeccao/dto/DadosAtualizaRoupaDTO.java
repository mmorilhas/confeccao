package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.entities.roupa.enums.Genero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaRoupaDTO(
		
		@NotNull Long id,
		@NotNull String nome,
		@NotBlank String tipoRoupa,
		@NotNull Integer tamanho,
		@NotNull Genero genero,
		@NotNull String cor,
		@NotNull Boolean temEstampa,
		@NotNull Boolean temBordado,
		@Valid DadosCadastroModelagemDTO modelagem,
		@Valid DadosCadastroTecidoDTO tecido,
		@Valid DadosCadastroParteDeCimaDTO parteDeCima
	
		
		) {

	
	
}
