package br.com.magna.confeccao.domain.partecima.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.domain.partecima.Cava;
import br.com.magna.confeccao.domain.partecima.Decote;
import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.repository.CavaRepository;
import br.com.magna.confeccao.repository.DecoteRepository;

@Component
public class ValidacaoTomaraQueCaiaNaoTemCava implements ValidadorParteCima{
	
	@Autowired
	private DecoteRepository decoteRepository;
	@Autowired
	private CavaRepository cavaRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		Decote decote = decoteRepository.getReferenceById(dados.idDecote());
		Cava cava = cavaRepository.getReferenceById(dados.idCava());
		
		if(decote.getDescricao().equalsIgnoreCase("tomara que caia") && !cava.getDescricao().equalsIgnoreCase("sem")) {
			throw new ValidacaoException("Peças tomara-que-caia não possuem cava");
		}
		
	}


	
}
