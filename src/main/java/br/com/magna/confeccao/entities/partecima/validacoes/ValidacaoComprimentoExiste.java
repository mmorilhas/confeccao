package br.com.magna.confeccao.entities.partecima.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.CavaDomain;
import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;
import br.com.magna.confeccao.repository.CavaRepository;
import br.com.magna.confeccao.repository.ComprimentoRepository;
import br.com.magna.confeccao.repository.DecoteRepository;
import br.com.magna.confeccao.repository.MangaRepository;

@Component
public class ValidacaoComprimentoExiste implements ValidadorParteCima{
	
	@Autowired
	private ComprimentoRepository comprimentoRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		if (!comprimentoRepository.existsById(dados.getIdComprimento())) {
			throw new ValidacaoException("Id de Comprimento informado não existe");
		}
	}


	
}
