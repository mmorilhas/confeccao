package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.roupa.Genero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaRoupaDTO(
		
		@NotNull Long id,
		@NotNull String nome,
		@NotNull Integer tamanho,
		@NotNull Genero genero,
		@NotNull String cor,
		@NotNull Boolean temEstampa,
		@NotNull Boolean temBordado,
		@Valid DadosAtualizaModelagemDTO modelagem,
		@Valid DadosCadastroTecidoDTO tecido,
		@Valid DadosAtualizaParteDeCimaDTO parteDeCima
	
		
		) {

	
	
}
