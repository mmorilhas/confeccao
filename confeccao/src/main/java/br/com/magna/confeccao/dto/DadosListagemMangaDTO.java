package br.com.magna.confeccao.dto;

import br.com.magna.confeccao.domain.partecima.Manga;

public record DadosListagemMangaDTO(


		Long id,
		String comprimento,
		String tipo
		
		) {
	
	public DadosListagemMangaDTO(Manga manga) {
		this(manga.getId(), manga.getComprimento(), manga.getTipo());
	}
}
