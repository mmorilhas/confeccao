package br.com.magna.confeccao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.CavaDomain;
import br.com.magna.confeccao.entities.domain.partecima.ComprimentoParteCimaDomain;
import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;
import br.com.magna.confeccao.entities.domain.partecima.MangaDomain;
import br.com.magna.confeccao.entities.partecima.ParteDeCima;
import br.com.magna.confeccao.entities.partecima.validacoes.ValidadorParteCima;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.repository.CavaDomainRepository;
import br.com.magna.confeccao.repository.ComprimentoDomainRepository;
import br.com.magna.confeccao.repository.DecoteDomainRepository;
import br.com.magna.confeccao.repository.MangaDomainRepository;
import br.com.magna.confeccao.repository.RoupaRepository;
import jakarta.validation.Valid;

@Service
public class ParteDeCimaService {

	@Autowired
	private MangaDomainRepository mangaRepository;
	@Autowired
	private DecoteDomainRepository decoteRepository;
	@Autowired
	private CavaDomainRepository cavaRepository;
	@Autowired
	private ComprimentoDomainRepository comprimentoRepository;
	@Autowired
	private RoupaRepository roupaRepository;
	@Autowired
	private List<ValidadorParteCima> validadores;

	public ParteDeCima criarParteDeCima(@Valid DadosCadastroParteDeCimaDTO dados) {

		validadores.forEach(v -> v.validar(dados));
		
		ParteDeCima parteDeCima = new ParteDeCima();
		parteDeCima.setManga(mangaRepository.getReferenceById(dados.getIdManga()));
		parteDeCima.setDecote(decoteRepository.getReferenceById(dados.getIdDecote()));
		parteDeCima.setCava(cavaRepository.getReferenceById(dados.getIdCava()));
		parteDeCima.setCapuz(dados.getCapuz());
		parteDeCima.setComprimento(comprimentoRepository.getReferenceById(dados.getIdComprimento()));

		return parteDeCima;
	}

	public ParteDeCima atualizaParteDeCima(Long idRoupa, @Valid DadosCadastroParteDeCimaDTO dados) {
		validadores.forEach(v -> v.validar(dados));
		
		Roupa roupa = roupaRepository.getReferenceById(idRoupa);
		ParteDeCima parteDeCima = roupa.getParteDeCima();
		parteDeCima.setManga(mangaRepository.getReferenceById(dados.getIdManga()));
		parteDeCima.setDecote(decoteRepository.getReferenceById(dados.getIdDecote()));
		parteDeCima.setCava(cavaRepository.getReferenceById(dados.getIdCava()));
		parteDeCima.setCapuz(dados.getCapuz());
		parteDeCima.setComprimento(comprimentoRepository.getReferenceById(dados.getIdComprimento()));

		return parteDeCima;
	}


}
