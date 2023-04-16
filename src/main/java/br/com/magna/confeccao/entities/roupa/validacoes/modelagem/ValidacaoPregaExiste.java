package br.com.magna.confeccao.entities.roupa.validacoes.modelagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.entities.roupa.validacoes.ValidacaoException;
import br.com.magna.confeccao.repository.domain.PregaDomainRepository;

@Component
public class ValidacaoPregaExiste implements ValidadorModelagem{
	
	@Autowired
	private PregaDomainRepository pregaRepository;

	@Override
	public void validar(DadosCadastroModelagemDTO dados) {
		if (Boolean.FALSE.equals(pregaRepository.existsByPrega(dados.getPrega()))) {
			throw new ValidacaoException("Id de Prega informado não existe");
		}
		
	}


	
}
