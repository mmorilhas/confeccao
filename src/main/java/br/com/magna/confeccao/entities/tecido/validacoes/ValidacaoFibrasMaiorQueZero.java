package br.com.magna.confeccao.entities.tecido.validacoes;

import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroTecidoDTO;
import br.com.magna.confeccao.entities.ValidacaoException;

@Component
public class ValidacaoFibrasMaiorQueZero implements ValidadorTecido{

	@Override
	public void validar(DadosCadastroTecidoDTO dados) {
		
		if(dados.idDasFibras().length == 0) {
			throw new ValidacaoException("Necessário inserir pelo menos uma fibra na composição");
		}
		
	}

}