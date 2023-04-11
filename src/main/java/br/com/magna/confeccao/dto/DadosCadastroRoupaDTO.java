package br.com.magna.confeccao.dto;

import org.hibernate.validator.constraints.Range;

import br.com.magna.confeccao.entities.roupa.enums.Genero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroRoupaDTO(
		
		@NotBlank String nome,
		@NotBlank String tipoRoupa,
		@NotNull @Range(min=10, max=70) Integer tamanho,
		@NotNull Genero genero,
		@NotBlank String cor,
		@NotNull Boolean temEstampa,
		@NotNull Boolean temBordado,
		@NotNull @Valid DadosCadastroModelagemDTO modelagem,
		@NotNull @Valid DadosCadastroTecidoDTO tecido,
		@NotNull @Valid DadosCadastroParteDeCimaDTO parteDeCima
	
		
		) {

	
	
}
