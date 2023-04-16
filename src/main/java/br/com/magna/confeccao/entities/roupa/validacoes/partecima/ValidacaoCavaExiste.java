package br.com.magna.confeccao.entities.roupa.validacoes.partecima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.roupa.validacoes.ValidacaoException;
import br.com.magna.confeccao.repository.domain.CavaDomainRepository;

@Component
public class ValidacaoCavaExiste implements ValidadorParteCima{
	
	@Autowired
	private CavaDomainRepository cavaRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		if (Boolean.FALSE.equals(cavaRepository.existsByCava(dados.getCava()))) {
			throw new ValidacaoException("Cava informada não existe");
		}
	}


	
}
