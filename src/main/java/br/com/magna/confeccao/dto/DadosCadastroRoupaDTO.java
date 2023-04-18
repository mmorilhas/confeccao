package br.com.magna.confeccao.dto;

import org.hibernate.validator.constraints.Range;

import br.com.magna.confeccao.entities.roupa.enums.Genero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DadosCadastroRoupaDTO{
		
		@NotBlank String nome;
		@NotBlank String colecao;
		@NotBlank String tipoRoupa;
		@NotNull @Range(min=10, max=70) Integer tamanhoInicial;
		@NotNull @Range(min=10, max=70) Integer tamanhoFinal;
		@NotNull @Min(1) Integer quantidadePorTamanho;
		@NotNull Genero genero;
		@NotBlank String cor;
		@NotNull Boolean temEstampa;
		@NotNull Boolean temBordado;
		@NotNull @Valid DadosCadastroModelagemDTO modelagem;
		@NotNull @Valid DadosCadastroTecidoDTO tecido;
		@NotNull @Valid DadosCadastroParteDeCimaDTO parteDeCima;
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getColecao() {
			return colecao;
		}
		public void setColecao(String colecao) {
			this.colecao = colecao;
		}
		public String getTipoRoupa() {
			return tipoRoupa;
		}
		public void setTipoRoupa(String tipoRoupa) {
			this.tipoRoupa = tipoRoupa;
		}
		public Integer getTamanhoInicial() {
			return tamanhoInicial;
		}
		public void setTamanhoInicial(Integer tamanhoInicial) {
			this.tamanhoInicial = tamanhoInicial;
		}
		public Integer getTamanhoFinal() {
			return tamanhoFinal;
		}
		public void setTamanhoFinal(Integer tamanhoFinal) {
			this.tamanhoFinal = tamanhoFinal;
		}
		public Integer getQuantidadePorTamanho() {
			return quantidadePorTamanho;
		}
		public void setQuantidadePorTamanho(Integer quantidadePorTamanho) {
			this.quantidadePorTamanho = quantidadePorTamanho;
		}
		public Genero getGenero() {
			return genero;
		}
		public void setGenero(Genero genero) {
			this.genero = genero;
		}
		public String getCor() {
			return cor;
		}
		public void setCor(String cor) {
			this.cor = cor;
		}
		public Boolean getTemEstampa() {
			return temEstampa;
		}
		public void setTemEstampa(Boolean temEstampa) {
			this.temEstampa = temEstampa;
		}
		public Boolean getTemBordado() {
			return temBordado;
		}
		public void setTemBordado(Boolean temBordado) {
			this.temBordado = temBordado;
		}
		public DadosCadastroModelagemDTO getModelagem() {
			return modelagem;
		}
		public void setModelagem(DadosCadastroModelagemDTO modelagem) {
			this.modelagem = modelagem;
		}
		public DadosCadastroTecidoDTO getTecido() {
			return tecido;
		}
		public void setTecido(DadosCadastroTecidoDTO tecido) {
			this.tecido = tecido;
		}
		public DadosCadastroParteDeCimaDTO getParteDeCima() {
			return parteDeCima;
		}
		public void setParteDeCima(DadosCadastroParteDeCimaDTO parteDeCima) {
			this.parteDeCima = parteDeCima;
		}
		

	
		
		

	
	
}
