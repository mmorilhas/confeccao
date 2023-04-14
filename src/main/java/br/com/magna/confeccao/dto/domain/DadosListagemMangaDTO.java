package br.com.magna.confeccao.dto.domain;

import br.com.magna.confeccao.entities.domain.partecima.MangaDomain;

public record DadosListagemMangaDTO(


		Long id,
		String manga
		
		) {
	
	public DadosListagemMangaDTO(MangaDomain manga) {
		this(manga.getId(), manga.getDescricaoManga());
	}
}
