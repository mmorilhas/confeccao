package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.entities.tecido.ConstrucaoEnum;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTecidoDTO(
		
		@NotNull Long[] idDasFibras,
		@NotNull ConstrucaoEnum construcao
				
		) {

	
	
	
	
}
