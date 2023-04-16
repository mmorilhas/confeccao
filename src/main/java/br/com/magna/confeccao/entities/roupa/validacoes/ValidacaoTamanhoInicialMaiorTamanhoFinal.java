package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;

@Component
public class ValidacaoTamanhoInicialMaiorTamanhoFinal implements ValidadorRoupaCadastro,  ValidadorRoupaAtualizar {



	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
		if(dados.getTamanhoFinal() < dados.getTamanhoInicial()) {
			throw new ValidacaoException("Tamanho Final precisa ser igual ou maior que Tamanho Inicial");
		}
		
	}

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		if(dados.getTamanhoFinal() < dados.getTamanhoInicial()) {
			throw new ValidacaoException("Tamanho Final precisa ser igual ou maior que Tamanho Inicial");
		}
		
	}

}
