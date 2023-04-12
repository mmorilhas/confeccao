package br.com.magna.confeccao.entities.modelagem.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.repository.PregaDomainRepository;

@Component
public class ValidacaoPregaExiste implements ValidadorModelagem{
	
	@Autowired
	private PregaDomainRepository pregaRepository;

	@Override
	public void validar(DadosCadastroModelagemDTO dados) {
		if (!pregaRepository.existsById(dados.getIdPrega())) {
			throw new ValidacaoException("Id de Prega informado não existe");
		}
		
	}


	
}
