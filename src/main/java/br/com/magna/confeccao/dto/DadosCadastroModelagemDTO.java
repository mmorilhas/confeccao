package br.com.magna.confeccao.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DadosCadastroModelagemDTO{
		
		
		@NotNull String silhueta; 
		@NotNull String fechamento;
		
		@NotNull Boolean cinto;
		@NotNull Boolean passantes;
		
		@NotNull Boolean pences;
		@NotNull Boolean pala;
		
		@NotNull String prega;
		
		@NotNull Boolean babado;
		@NotNull Boolean fenda;
		
		@NotNull @Positive Integer bolsos;
		
		@NotNull Boolean forro;
		@NotNull String barra;
		
		
		public String getSilhueta() {
			return silhueta;
		}
		public void setSilhueta(String silhueta) {
			this.silhueta = silhueta;
		}
		public String getFechamento() {
			return fechamento;
		}
		public void setFechamento(String fechamento) {
			this.fechamento = fechamento;
		}
		public Boolean getCinto() {
			return cinto;
		}
		public void setCinto(Boolean cinto) {
			this.cinto = cinto;
		}
		public Boolean getPassantes() {
			return passantes;
		}
		public void setPassantes(Boolean passantes) {
			this.passantes = passantes;
		}
		public Boolean getPences() {
			return pences;
		}
		public void setPences(Boolean pences) {
			this.pences = pences;
		}
		public Boolean getPala() {
			return pala;
		}
		public void setPala(Boolean pala) {
			this.pala = pala;
		}
		public String getPrega() {
			return prega;
		}
		public void setPrega(String prega) {
			this.prega = prega;
		}
		public Boolean getBabado() {
			return babado;
		}
		public void setBabado(Boolean babado) {
			this.babado = babado;
		}
		public Boolean getFenda() {
			return fenda;
		}
		public void setFenda(Boolean fenda) {
			this.fenda = fenda;
		}
		public Integer getBolsos() {
			return bolsos;
		}
		public void setBolsos(Integer bolsos) {
			this.bolsos = bolsos;
		}
		public Boolean getForro() {
			return forro;
		}
		public void setForro(Boolean forro) {
			this.forro = forro;
		}
		public String getBarra() {
			return barra;
		}
		public void setBarra(String barra) {
			this.barra = barra;
		}
		
		
		
		


}
