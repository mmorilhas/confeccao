package br.com.magna.confeccao.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DadosCadastroModelagemDTO{
		
		
		@NotNull Long idSilhueta; 
		@NotNull Long idFechamento;
		
		@NotNull Boolean cinto;
		@NotNull Boolean passantes;
		
		@NotNull Boolean pences;
		@NotNull Boolean pala;
		
		@NotNull Long idPrega;
		
		@NotNull Boolean babado;
		@NotNull Boolean fenda;
		
		@NotNull @Positive Integer bolsos;
		
		@NotNull Boolean forro;
		@NotNull Long idBarra;
		
		
		public void setIdSilhueta(Long idSilhueta) {
			this.idSilhueta = idSilhueta;
		}
		public void setIdFechamento(Long idFechamento) {
			this.idFechamento = idFechamento;
		}
		public void setCinto(Boolean cinto) {
			this.cinto = cinto;
		}
		public void setPassantes(Boolean passantes) {
			this.passantes = passantes;
		}
		public void setPences(Boolean pences) {
			this.pences = pences;
		}
		public void setPala(Boolean pala) {
			this.pala = pala;
		}
		public void setIdPrega(Long idPrega) {
			this.idPrega = idPrega;
		}
		public void setBabado(Boolean babado) {
			this.babado = babado;
		}
		public void setFenda(Boolean fenda) {
			this.fenda = fenda;
		}
		public void setBolsos(Integer bolsos) {
			this.bolsos = bolsos;
		}
		public void setForro(Boolean forro) {
			this.forro = forro;
		}
		public void setIdBarra(Long idBarra) {
			this.idBarra = idBarra;
		}
		public Long getIdSilhueta() {
			return idSilhueta;
		}
		public Long getIdFechamento() {
			return idFechamento;
		}
		public Boolean getCinto() {
			return cinto;
		}
		public Boolean getPassantes() {
			return passantes;
		}
		public Boolean getPences() {
			return pences;
		}
		public Boolean getPala() {
			return pala;
		}
		public Long getIdPrega() {
			return idPrega;
		}
		public Boolean getBabado() {
			return babado;
		}
		public Boolean getFenda() {
			return fenda;
		}
		public Integer getBolsos() {
			return bolsos;
		}
		public Boolean getForro() {
			return forro;
		}
		public Long getIdBarra() {
			return idBarra;
		}
		
		


}
