package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.roupa.Genero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaRoupaDTO(
		
		@NotNull Long id,
		String nome,
		Integer tamanho,
		Genero genero,
		String cor,
		Boolean temEstampa,
		Boolean temBordado,
		@Valid DadosAtualizaModelagemDTO modelagem,
		@Valid DadosAtualizaTecidoDTO tecido,
		@Valid DadosAtualizaParteDeCimaDTO parteDeCima
	
		
		) {

	
	
}
