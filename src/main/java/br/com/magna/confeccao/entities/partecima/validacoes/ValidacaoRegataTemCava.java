package br.com.magna.confeccao.entities.partecima.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.CavaDomain;
import br.com.magna.confeccao.entities.domain.partecima.MangaDomain;
import br.com.magna.confeccao.repository.CavaRepository;
import br.com.magna.confeccao.repository.MangaRepository;

@Component
public class ValidacaoRegataTemCava implements ValidadorParteCima{
	
	@Autowired
	private MangaRepository mangaRepository;
	@Autowired
	private CavaRepository cavaRepository;

	@Override
	public void validar(DadosCadastroParteDeCimaDTO dados) {
		MangaDomain manga = mangaRepository.getReferenceById(dados.getIdManga());
		CavaDomain cava = cavaRepository.getReferenceById(dados.getIdCava());
		
		if(manga.getComprimento().contains("regata") && cava.getDescricao().equalsIgnoreCase("sem")) {
			throw new ValidacaoException("Peças regatas precisam possuir cava");
		}
		
	}


	
}
