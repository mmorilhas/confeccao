package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.repository.domain.DecoteDomainRepository;

@Component
public class ValidacaoCapuzNaoTemColarinhoLapelaTomaraQueCaia implements ValidadorRoupaCadastro {

	@Autowired
	private DecoteDomainRepository decoteRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		String decote = decoteRepository.findyByDecote(dados.getParteDeCima().getDecote());

		if ((decote.contains("colarinho") || decote.contains("lapela") || decote.contains("tomara que caia")) && Boolean.TRUE.equals(dados.getParteDeCima().getCapuz())) {
			throw new ValidacaoException("Peças Tomara que Caia ou com Colarinho/Lapela não possuem capuz");
		}

	}

}
