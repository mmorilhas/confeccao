package br.com.magna.confeccao.entities.roupa.validacoes.modelagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.repository.domain.FechamentoDomainRepository;
import br.com.magna.confeccao.repository.domain.SilhuetaDomainRepository;

@Component
public class ValidacaoFechamentoExiste implements ValidadorModelagem{
	
	@Autowired
	private FechamentoDomainRepository fechamentoRepository;

	@Override
	public void validar(DadosCadastroModelagemDTO dados) {
		if (Boolean.FALSE.equals(fechamentoRepository.existsByFechamento(dados.getFechamento()))) {
			throw new ValidacaoException("Id de Fechamento informado não existe");
		}
		
	}


	
}
