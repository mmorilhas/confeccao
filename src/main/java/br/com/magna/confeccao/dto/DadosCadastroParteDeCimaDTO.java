package br.com.magna.confeccao.dto;

import jakarta.validation.constraints.NotNull;

public class DadosCadastroParteDeCimaDTO{
		
		@NotNull Long idManga;
		@NotNull Long idDecote;
		@NotNull Long idCava;
		@NotNull Boolean capuz;
		@NotNull Long idComprimento;
		
		public Long getIdManga() {
			return idManga;
		}
		public void setIdManga(Long idManga) {
			this.idManga = idManga;
		}
		public Long getIdDecote() {
			return idDecote;
		}
		public void setIdDecote(Long idDecote) {
			this.idDecote = idDecote;
		}
		public Long getIdCava() {
			return idCava;
		}
		public void setIdCava(Long idCava) {
			this.idCava = idCava;
		}
		public Boolean getCapuz() {
			return capuz;
		}
		public void setCapuz(Boolean capuz) {
			this.capuz = capuz;
		}
		public Long getIdComprimento() {
			return idComprimento;
		}
		public void setIdComprimento(Long idComprimento) {
			this.idComprimento = idComprimento;
		}
		
		
		
		
		

	
	
}
