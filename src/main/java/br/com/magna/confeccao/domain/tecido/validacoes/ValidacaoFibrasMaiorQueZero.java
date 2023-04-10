package br.com.magna.confeccao.domain.tecido.validacoes;

import org.springframework.stereotype.Component;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.dto.DadosCadastroTecidoDTO;

@Component
public class ValidacaoFibrasMaiorQueZero implements ValidadorTecido{

	@Override
	public void validar(DadosCadastroTecidoDTO dados) {
		
		if(dados.idDasFibras().length == 0) {
			throw new ValidacaoException("Necessário inserir pelo menos uma fibra na composição");
		}
		
	}

}
