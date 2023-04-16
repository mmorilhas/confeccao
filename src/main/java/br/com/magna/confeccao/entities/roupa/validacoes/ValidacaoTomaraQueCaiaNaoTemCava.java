package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.repository.domain.CavaDomainRepository;
import br.com.magna.confeccao.repository.domain.DecoteDomainRepository;

@Component
public class ValidacaoTomaraQueCaiaNaoTemCava implements ValidadorRoupaCadastro{
	
	@Autowired
	private DecoteDomainRepository decoteRepository;
	@Autowired
	private CavaDomainRepository cavaRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		String decote = decoteRepository.findyByDecote(dados.getParteDeCima().getDecote());
		String cava = cavaRepository.findyByCava(dados.getParteDeCima().getCava());
		
		if(decote.equalsIgnoreCase("tomara que caia") && !cava.equalsIgnoreCase("sem")) {
			throw new ValidacaoException("Peças tomara-que-caia não possuem cava");
		}
		
	}


	
}
