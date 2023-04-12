package br.com.magna.confeccao.entities.modelagem.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.repository.FechamentoRepository;

@Component
public class ValidacaoFechamentoExiste implements ValidadorModelagem {

	@Autowired
	private FechamentoRepository fechamentoRepository;

	@Override
	public void validar(DadosCadastroModelagemDTO dados) {
		if (!fechamentoRepository.existsById(dados.getIdFechamento())) {
			throw new ValidacaoException("Id de Fechamento informado não existe");
		}

	}

}
