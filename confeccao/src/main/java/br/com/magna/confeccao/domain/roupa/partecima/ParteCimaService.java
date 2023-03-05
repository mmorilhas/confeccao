package br.com.magna.confeccao.domain.roupa.partecima;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.modelagem.ModelagemService;
import br.com.magna.confeccao.domain.tecido.Tecido;
import br.com.magna.confeccao.domain.tecido.TecidoService;

@Service
public class ParteCimaService {

	
	@Autowired private TecidoService tecidoService;
	@Autowired private ModelagemService modelagemService;
	@Autowired private ParteDeCimaRepository parteDeCimaRepository;
	
	@Autowired private MangaRepository mangaRepository;
	@Autowired private DecoteRepository decoteRepository;
	
	public void criarParteDeCima(DadosCadastroParteDeCima dados) {
		
		Modelagem modelagem = modelagemService.criarModelagem(dados.roupa().modelagem());
		Tecido tecido = tecidoService.criarTecido(dados.roupa().tecido());
		Manga manga = null;
		Decote decote = null;
	
		if(mangaRepository.existsById(dados.idManga())) {
			manga = mangaRepository.getReferenceById(dados.idManga());
		}
		if(decoteRepository.existsById(dados.idDecote())) {
			decote = decoteRepository.getReferenceById(dados.idDecote());
		}
		
		ParteDeCima parteDeCima = new ParteDeCima(dados, dados.roupa(), modelagem, tecido, manga, decote);
	
		
		parteDeCimaRepository.save(parteDeCima);
		
	}
	
	public List<DadosListagemParteDeCima> listagem() {
		List<DadosListagemParteDeCima> roupas = parteDeCimaRepository.findAll().stream().map(DadosListagemParteDeCima::new).toList();
		
		return roupas;
		
	}
}
