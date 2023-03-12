package br.com.magna.confeccao.domain.roupa.partecima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.domain.roupa.Roupa;
import br.com.magna.confeccao.domain.roupa.RoupaRepository;

@Service
public class ParteDeCimaService {

	@Autowired private MangaRepository mangaRepository;
	@Autowired private DecoteRepository decoteRepository;
	@Autowired private CavaRepository cavaRepository;
	@Autowired private ComprimentoRepository comprimentoRepository;
	@Autowired private RoupaRepository roupaRepository;
	
	public ParteDeCima criarParteDeCima(DadosCadastroParteDeCima dados) {
		
		ParteDeCima parteDeCima = new ParteDeCima(verificaEPegaManga(dados.idManga()),
				verificaEPegaDecote(dados.idDecote()), 
				verificaEPegaCava(dados.idCava()),
				dados.capuz(), 
				verificaEPegaComprimento(dados.idComprimento()));

		return parteDeCima;
	}
	

	public ParteDeCima atualizaParteDeCima(Long idRoupa, DadosAtualizaParteDeCima dados) {
		Roupa roupa = roupaRepository.getReferenceById(idRoupa);
		ParteDeCima parteDeCima = roupa.getParteDeCima();
		if (dados.idManga() != null) {
			parteDeCima.setManga(verificaEPegaManga(dados.idManga()));
		}
		if (dados.idDecote() != null) {
			parteDeCima.setDecote(verificaEPegaDecote(dados.idDecote()));
		}
		if (dados.idCava() != null) {
			parteDeCima.setCava(verificaEPegaCava(dados.idCava()));
		}
		if (dados.capuz() != null) {
			parteDeCima.setCapuz(dados.capuz());
		}

		return parteDeCima;
	}
	

	private Manga verificaEPegaManga(Long idManga) {
		if (! mangaRepository.existsById(idManga)) {
			throw new ValidacaoException("Id de Manga informado não existe");
		}
		Manga manga = mangaRepository.getReferenceById(idManga);
		return manga;
	}
	
	private Decote verificaEPegaDecote(Long idDecote) {
		if (! decoteRepository.existsById(idDecote)) {
			throw new ValidacaoException("Id de Decote informado não existe");
		}
		Decote decote = decoteRepository.getReferenceById(idDecote);
		return decote;
	}
	
	private Cava verificaEPegaCava(Long idCava) {
		if (! cavaRepository.existsById(idCava)) {
			throw new ValidacaoException("Id de Cava informado não existe");
		}
		Cava cava =  cavaRepository.getReferenceById(idCava);
		return cava;
	}

	private ComprimentoParteCima verificaEPegaComprimento(Long idComprimento) {
		if (! comprimentoRepository.existsById(idComprimento)) {
			throw new ValidacaoException("Id de Comprimento informado não existe");
		}
		ComprimentoParteCima comprimento =  comprimentoRepository.getReferenceById(idComprimento);
		return comprimento;
	}



	
}
