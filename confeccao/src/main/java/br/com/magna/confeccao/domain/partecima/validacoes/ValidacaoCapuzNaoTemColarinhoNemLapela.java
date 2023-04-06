package br.com.magna.confeccao.domain.partecima.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.domain.partecima.Decote;
import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.repository.DecoteRepository;

@Component
public class ValidacaoCapuzNaoTemColarinhoNemLapela implements ValidadorParteCima{
	
	@Autowired
	private DecoteRepository decoteRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		Decote decote = decoteRepository.getReferenceById(dados.idDecote());
		
		if((decote.getDescricao().contains("colarinho") || decote.getDescricao().contains("lapela")) &&  Boolean.TRUE.equals(dados.capuz()) ) {
			throw new ValidacaoException("Peças com Colarinho ou Lapela não possuem capuz");
		}
		
	}
	


	
}
