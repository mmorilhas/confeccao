package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.entities.tecido.ConstrucaoEnum;
import jakarta.validation.constraints.NotNull;

public class DadosCadastroTecidoDTO{

		
		@NotNull Long[] idDasFibras;
		@NotNull ConstrucaoEnum construcao;
		
		
		public Long[] getIdDasFibras() {
			return idDasFibras;
		}
		public ConstrucaoEnum getConstrucao() {
			return construcao;
		}
		public void setIdDasFibras(Long[] idDasFibras) {
			this.idDasFibras = idDasFibras;
		}
		public void setConstrucao(ConstrucaoEnum construcao) {
			this.construcao = construcao;
		}
				
		

	
	
	
	
}
