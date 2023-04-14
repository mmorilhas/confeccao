package br.com.magna.confeccao.entities.roupa.validacoes.partecima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.CavaDomain;
import br.com.magna.confeccao.entities.domain.partecima.MangaDomain;
import br.com.magna.confeccao.repository.domain.CavaDomainRepository;
import br.com.magna.confeccao.repository.domain.MangaDomainRepository;

@Component
public class ValidacaoRegataTemCava implements ValidadorParteCima {

	@Autowired
	private MangaDomainRepository mangaRepository;
	@Autowired
	private CavaDomainRepository cavaRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		String manga = mangaRepository.findyByManga(dados.getManga());
		String cava = cavaRepository.findyByCava(dados.getCava());

		if (manga.contains("regata") && cava.equalsIgnoreCase("sem")) {
			throw new ValidacaoException("Peças regatas precisam possuir cava");
		}

	}

}
