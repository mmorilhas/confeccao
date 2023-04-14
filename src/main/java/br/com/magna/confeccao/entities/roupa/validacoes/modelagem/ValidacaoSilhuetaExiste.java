package br.com.magna.confeccao.entities.roupa.validacoes.modelagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.repository.domain.SilhuetaDomainRepository;

@Component
public class ValidacaoSilhuetaExiste implements ValidadorModelagem{
	
	@Autowired
	private SilhuetaDomainRepository silhuetaRepository;

	@Override
	public void validar(DadosCadastroModelagemDTO dados) {
		if (Boolean.FALSE.equals(silhuetaRepository.existsBySilhueta(dados.getSilhueta()))) {
			throw new ValidacaoException("Id de Silhueta informado não existe");
		}
		
	}


	
}
