package br.com.magna.confeccao.domain.roupa.partecima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.roupa.RoupaRepository;

@Service
public class ParteDeCimaService {

	@Autowired
	private MangaRepository mangaRepository;
	@Autowired
	private DecoteRepository decoteRepository;
	@Autowired CavaRepository cavaRepository;
	@Autowired ComprimentoRepository comprimentoRepository;

	public ParteDeCima criarParteDeCima(DadosCadastroParteDeCima dados) {
		Manga manga = null;
		Decote decote = null;
		Cava cava = null;
		ComprimentoParteCima cpc = null;

		if (mangaRepository.existsById(dados.idManga())) {
			manga = mangaRepository.getReferenceById(dados.idManga());
		}
		if (decoteRepository.existsById(dados.idDecote())) {
			decote = decoteRepository.getReferenceById(dados.idDecote());
		}
		if(cavaRepository.existsById(dados.idCava())) {
			cava = cavaRepository.getReferenceById(dados.idCava());
		}
		
		if(comprimentoRepository.existsById(dados.idComprimento())) {
			cpc = comprimentoRepository.getReferenceById(dados.idComprimento());
		}
		
		ParteDeCima parteDeCima = new ParteDeCima(manga, decote, cava, dados.capuz(), cpc);

		return parteDeCima;

	}

	public ParteDeCima atualizaParteDeCima(DadosAtualizaParteDeCima dados) {
		ParteDeCima parteDeCima = new ParteDeCima();
		if (dados.idManga() != null) {
			if (mangaRepository.existsById(dados.idManga())) {
				Manga manga = mangaRepository.getReferenceById(dados.idManga());
				parteDeCima.setManga(manga);
			}
		}
		if (dados.idDecote() != null) {
			if (decoteRepository.existsById(dados.idDecote())) {
				Decote decote = decoteRepository.getReferenceById(dados.idDecote());
				parteDeCima.setDecote(decote);
			}
		}
		if (dados.idCava() != null) {
			if(cavaRepository.existsById(dados.idCava())) {
				Cava cava = cavaRepository.getReferenceById(dados.idCava());
				parteDeCima.setCava(cava);
			}
		}
		if (dados.capuz() != null) {
			parteDeCima.setCapuz(dados.capuz());
		}

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
