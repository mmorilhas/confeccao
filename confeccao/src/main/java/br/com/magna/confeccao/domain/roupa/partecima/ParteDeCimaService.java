package br.com.magna.confeccao.domain.roupa.partecima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParteDeCimaService {

	@Autowired private MangaRepository mangaRepository;
	@Autowired private DecoteRepository decoteRepository;
	
	public ParteDeCima criarParteDeCima(DadosCadastroParteDeCima dados) {
		Manga manga = null;
		Decote decote = null;
	
		if(mangaRepository.existsById(dados.idManga())) {
			manga = mangaRepository.getReferenceById(dados.idManga());
		}
		if(decoteRepository.existsById(dados.idDecote())) {
			decote = decoteRepository.getReferenceById(dados.idDecote());
		}
		
		ParteDeCima parteDeCima = new ParteDeCima(manga, decote, dados.cava(), dados.capuz());
	
		
		return parteDeCima;
		
	}
	/*
	 * public List<DadosListagemParteDeCima> listagem() {
	 * List<DadosListagemParteDeCima> roupas =
	 * parteDeCimaRepository.findAll().stream().map(DadosListagemParteDeCima::new).
	 * toList();
	 * 
	 * return roupas;
	 * 
	 * }
	 */
}
