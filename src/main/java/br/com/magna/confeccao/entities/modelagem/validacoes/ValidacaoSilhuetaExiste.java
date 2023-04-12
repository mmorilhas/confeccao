package br.com.magna.confeccao.entities.modelagem.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.repository.SilhuetaRepository;

@Component
public class ValidacaoSilhuetaExiste implements ValidadorModelagem{
	
	@Autowired
	private SilhuetaRepository silhuetaRepository;;

	@Override
	public void validar(DadosCadastroModelagemDTO dados) {
		if (!silhuetaRepository.existsById(dados.getIdSilhueta())) {
			throw new ValidacaoException("Id de Silhueta informado não existe");
		}
		
	}


	
}
