package br.com.magna.confeccao.dto;

import jakarta.validation.constraints.NotNull;

public class DadosCadastroParteDeCimaDTO{
		
		@NotNull String manga;
		@NotNull String decote;
		@NotNull String cava;
		@NotNull Boolean capuz;
		@NotNull String comprimento;
		
		public String getManga() {
			return manga;
		}
		public void setManga(String manga) {
			this.manga = manga;
		}
		public String getDecote() {
			return decote;
		}
		public void setDecote(String decote) {
			this.decote = decote;
		}
		public String getCava() {
			return cava;
		}
		public void setCava(String cava) {
			this.cava = cava;
		}
		public Boolean getCapuz() {
			return capuz;
		}
		public void setCapuz(Boolean capuz) {
			this.capuz = capuz;
		}
		public String getComprimento() {
			return comprimento;
		}
		public void setComprimento(String comprimento) {
			this.comprimento = comprimento;
		}
		
		
		
		
		

	
	
}
