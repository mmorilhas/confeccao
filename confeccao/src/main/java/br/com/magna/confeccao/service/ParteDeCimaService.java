package br.com.magna.confeccao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.domain.partecima.Cava;
import br.com.magna.confeccao.domain.partecima.ComprimentoParteCima;
import br.com.magna.confeccao.domain.partecima.Decote;
import br.com.magna.confeccao.domain.partecima.Manga;
import br.com.magna.confeccao.domain.partecima.ParteDeCima;
import br.com.magna.confeccao.domain.partecima.validacoes.ValidadorParteCima;
import br.com.magna.confeccao.domain.roupa.Roupa;
import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.repository.CavaRepository;
import br.com.magna.confeccao.repository.ComprimentoRepository;
import br.com.magna.confeccao.repository.DecoteRepository;
import br.com.magna.confeccao.repository.MangaRepository;
import br.com.magna.confeccao.repository.RoupaRepository;
import jakarta.validation.Valid;

@Service
public class ParteDeCimaService {

	@Autowired
	private MangaRepository mangaRepository;
	@Autowired
	private DecoteRepository decoteRepository;
	@Autowired
	private CavaRepository cavaRepository;
	@Autowired
	private ComprimentoRepository comprimentoRepository;
	@Autowired
	private RoupaRepository roupaRepository;
	@Autowired
	private List<ValidadorParteCima> validadores;

	public ParteDeCima criarParteDeCima(@Valid DadosCadastroParteDeCimaDTO dados) {

		validadores.forEach(v -> v.validar(dados));
		
		ParteDeCima parteDeCima = new ParteDeCima();
		parteDeCima.setManga(verificaEPegaManga(dados.idManga()));
		parteDeCima.setDecote(verificaEPegaDecote(dados.idDecote()));
		parteDeCima.setCava(verificaEPegaCava(dados.idCava()));
		parteDeCima.setCapuz(dados.capuz());
		parteDeCima.setComprimento(verificaEPegaComprimento(dados.idComprimento()));

		return parteDeCima;
	}

	public ParteDeCima atualizaParteDeCima(Long idRoupa, @Valid DadosCadastroParteDeCimaDTO dados) {
		Roupa roupa = roupaRepository.getReferenceById(idRoupa);
		ParteDeCima parteDeCima = roupa.getParteDeCima();
		parteDeCima.setManga(verificaEPegaManga(dados.idManga()));
		parteDeCima.setDecote(verificaEPegaDecote(dados.idDecote()));
		parteDeCima.setCava(verificaEPegaCava(dados.idCava()));
		parteDeCima.setCapuz(dados.capuz());

		return parteDeCima;
	}

	private Manga verificaEPegaManga(Long idManga) {
		if (!mangaRepository.existsById(idManga)) {
			throw new ValidacaoException("Id de Manga informado não existe");
		}
		return mangaRepository.getReferenceById(idManga);
	}

	private Decote verificaEPegaDecote(Long idDecote) {
		if (!decoteRepository.existsById(idDecote)) {
			throw new ValidacaoException("Id de Decote informado não existe");
		}
		return decoteRepository.getReferenceById(idDecote);
	}

	private Cava verificaEPegaCava(Long idCava) {
		if (!cavaRepository.existsById(idCava)) {
			throw new ValidacaoException("Id de Cava informado não existe");
		}
		return cavaRepository.getReferenceById(idCava);
	}

	private ComprimentoParteCima verificaEPegaComprimento(Long idComprimento) {
		if (!comprimentoRepository.existsById(idComprimento)) {
			throw new ValidacaoException("Id de Comprimento informado não existe");
		}
		return comprimentoRepository.getReferenceById(idComprimento);
	}

}
