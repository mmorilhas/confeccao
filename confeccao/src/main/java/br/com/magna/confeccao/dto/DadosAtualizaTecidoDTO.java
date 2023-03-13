package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.tecido.Construcao;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaTecidoDTO(
		
		@NotNull Long id,
		Long[] idDasFibras,
		Construcao construcao
				
		) {

	
	
}
