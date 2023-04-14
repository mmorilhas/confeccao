package br.com.magna.confeccao.entities.roupa.validacoes.partecima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.CavaDomain;
import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;
import br.com.magna.confeccao.repository.domain.CavaDomainRepository;
import br.com.magna.confeccao.repository.domain.ComprimentoDomainRepository;
import br.com.magna.confeccao.repository.domain.DecoteDomainRepository;
import br.com.magna.confeccao.repository.domain.MangaDomainRepository;

@Component
public class ValidacaoDecoteExiste implements ValidadorParteCima{
	
	@Autowired
	private DecoteDomainRepository decoteRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		if (Boolean.FALSE.equals(decoteRepository.existsByDecote(dados.getDecote()))) {
			throw new ValidacaoException("Id de Decote informado não existe");
		}
	}


	
}
