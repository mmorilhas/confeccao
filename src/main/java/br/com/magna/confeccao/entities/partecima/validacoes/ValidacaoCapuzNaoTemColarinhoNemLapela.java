package br.com.magna.confeccao.entities.partecima.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;
import br.com.magna.confeccao.repository.DecoteRepository;

@Component
public class ValidacaoCapuzNaoTemColarinhoNemLapela implements ValidadorParteCima{
	
	@Autowired
	private DecoteRepository decoteRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		DecoteDomain decote = decoteRepository.getReferenceById(dados.idDecote());
		
		if((decote.getDescricao().contains("colarinho") || decote.getDescricao().contains("lapela")) &&  Boolean.TRUE.equals(dados.capuz()) ) {
			throw new ValidacaoException("Peças com Colarinho ou Lapela não possuem capuz");
		}
		
	}
	


	
}
