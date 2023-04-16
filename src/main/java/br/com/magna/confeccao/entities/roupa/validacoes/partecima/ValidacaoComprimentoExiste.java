package br.com.magna.confeccao.entities.roupa.validacoes.partecima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.roupa.validacoes.ValidacaoException;
import br.com.magna.confeccao.repository.domain.ComprimentoDomainRepository;

@Component
public class ValidacaoComprimentoExiste implements ValidadorParteCima{
	
	@Autowired
	private ComprimentoDomainRepository comprimentoRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		if (Boolean.FALSE.equals(comprimentoRepository.existsByComprimento(dados.getComprimento()))) {
			throw new ValidacaoException("Id de Comprimento informado não existe");
		}
	}


	
}
