package br.com.magna.confeccao.dto;

import org.hibernate.validator.constraints.Range;

import br.com.magna.confeccao.domain.roupa.Genero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroRoupaDTO(
		
		@NotBlank String nome,
		@NotNull @Range(min=10, max=70) Integer tamanho,
		@NotNull Genero genero,
		@NotBlank String cor,
		Boolean temEstampa,
		Boolean temBordado,
		@NotNull @Valid DadosCadastroModelagemDTO modelagem,
		@NotNull @Valid DadosCadastroTecidoDTO tecido,
		@NotNull @Valid DadosCadastroParteDeCimaDTO parteDeCima
	
		
		) {

	
	
}
