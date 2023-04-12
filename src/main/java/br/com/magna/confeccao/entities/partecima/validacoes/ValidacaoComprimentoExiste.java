package br.com.magna.confeccao.entities.partecima.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.CavaDomain;
import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;
import br.com.magna.confeccao.repository.CavaDomainRepository;
import br.com.magna.confeccao.repository.ComprimentoDomainRepository;
import br.com.magna.confeccao.repository.DecoteDomainRepository;
import br.com.magna.confeccao.repository.MangaDomainRepository;

@Component
public class ValidacaoComprimentoExiste implements ValidadorParteCima{
	
	@Autowired
	private ComprimentoDomainRepository comprimentoRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		if (!comprimentoRepository.existsById(dados.getIdComprimento())) {
			throw new ValidacaoException("Id de Comprimento informado não existe");
		}
	}


	
}
