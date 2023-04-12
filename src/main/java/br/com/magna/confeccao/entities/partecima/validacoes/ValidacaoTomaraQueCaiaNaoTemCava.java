package br.com.magna.confeccao.entities.partecima.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.CavaDomain;
import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;
import br.com.magna.confeccao.repository.CavaDomainRepository;
import br.com.magna.confeccao.repository.DecoteDomainRepository;

@Component
public class ValidacaoTomaraQueCaiaNaoTemCava implements ValidadorParteCima{
	
	@Autowired
	private DecoteDomainRepository decoteRepository;
	@Autowired
	private CavaDomainRepository cavaRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		DecoteDomain decote = decoteRepository.getReferenceById(dados.getIdDecote());
		CavaDomain cava = cavaRepository.getReferenceById(dados.getIdCava());
		
		if(decote.getDescricao().equalsIgnoreCase("tomara que caia") && !cava.getDescricao().equalsIgnoreCase("sem")) {
			throw new ValidacaoException("Peças tomara-que-caia não possuem cava");
		}
		
	}


	
}
