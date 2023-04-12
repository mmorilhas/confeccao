package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.entities.roupa.enums.Genero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DadosAtualizaRoupaDTO{
		
		@NotNull Long id;
		@NotNull String nome;
		@NotBlank String tipoRoupa;
		@NotNull Integer tamanho;
		@NotNull Genero genero;
		@NotNull String cor;
		@NotNull Boolean temEstampa;
		@NotNull Boolean temBordado;
		@Valid DadosCadastroModelagemDTO modelagem;
		@Valid DadosCadastroTecidoDTO tecido;
		@Valid DadosCadastroParteDeCimaDTO parteDeCima;
		
		
		
		
		public void setId(Long id) {
			this.id = id;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public void setTipoRoupa(String tipoRoupa) {
			this.tipoRoupa = tipoRoupa;
		}
		public void setTamanho(Integer tamanho) {
			this.tamanho = tamanho;
		}
		public void setGenero(Genero genero) {
			this.genero = genero;
		}
		public void setCor(String cor) {
			this.cor = cor;
		}
		public void setTemEstampa(Boolean temEstampa) {
			this.temEstampa = temEstampa;
		}
		public void setTemBordado(Boolean temBordado) {
			this.temBordado = temBordado;
		}
		public void setModelagem(DadosCadastroModelagemDTO modelagem) {
			this.modelagem = modelagem;
		}
		public void setTecido(DadosCadastroTecidoDTO tecido) {
			this.tecido = tecido;
		}
		public void setParteDeCima(DadosCadastroParteDeCimaDTO parteDeCima) {
			this.parteDeCima = parteDeCima;
		}
		
		
		public Long getId() {
			return id;
		}
		public String getNome() {
			return nome;
		}
		public String getTipoRoupa() {
			return tipoRoupa;
		}
		public Integer getTamanho() {
			return tamanho;
		}
		public Genero getGenero() {
			return genero;
		}
		public String getCor() {
			return cor;
		}
		public Boolean getTemEstampa() {
			return temEstampa;
		}
		public Boolean getTemBordado() {
			return temBordado;
		}
		public DadosCadastroModelagemDTO getModelagem() {
			return modelagem;
		}
		public DadosCadastroTecidoDTO getTecido() {
			return tecido;
		}
		public DadosCadastroParteDeCimaDTO getParteDeCima() {
			return parteDeCima;
		}
	
		
		

	
	
}
