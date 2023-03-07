package br.com.magna.confeccao.domain.roupa;

import br.com.magna.confeccao.domain.modelagem.DadosAtualizaModelagem;
import br.com.magna.confeccao.domain.modelagem.DadosCadastroModelagem;
import br.com.magna.confeccao.domain.roupa.partecima.DadosAtualizaParteDeCima;
import br.com.magna.confeccao.domain.roupa.partecima.DadosCadastroParteDeCima;
import br.com.magna.confeccao.domain.tecido.DadosAtualizaTecido;
import br.com.magna.confeccao.domain.tecido.DadosCadastroTecido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaRoupa(
		
		@NotNull Long id,
		String nome,
		Integer tamanho,
		Genero genero,
		String cor,
		@Valid DadosAtualizaModelagem modelagem,
		@Valid DadosAtualizaTecido tecido,
		Boolean temEstampa,
		Boolean temBordado,
		@Valid DadosAtualizaParteDeCima parteDeCima
	
		
		) {

	
	
}
