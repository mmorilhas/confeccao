package br.com.magna.confeccao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.entities.partecima.ParteDeCima;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.repository.RoupaRepository;
import br.com.magna.confeccao.repository.domain.CavaDomainRepository;
import br.com.magna.confeccao.repository.domain.ComprimentoDomainRepository;
import br.com.magna.confeccao.repository.domain.DecoteDomainRepository;
import br.com.magna.confeccao.repository.domain.MangaDomainRepository;
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
	

	public ParteDeCima criarParteDeCima(@Valid DadosCadastroParteDeCimaDTO dados) {

		ParteDeCima parteDeCima = new ParteDeCima();
		parteDeCima.setCapuz(dados.getCapuz());
		parteDeCima.setManga(mangaRepository.findyByManga(dados.getManga()));
		parteDeCima.setDecote(decoteRepository.findyByDecote(dados.getDecote()));
		parteDeCima.setCava(cavaRepository.findyByCava(dados.getCava()));
		parteDeCima.setComprimento(comprimentoRepository.findyByComprimento(dados.getComprimento()));
		
		

		return parteDeCima;
	}

	public ParteDeCima atualizaParteDeCima(Long idRoupa, @Valid DadosCadastroParteDeCimaDTO dados) {
		
		Roupa roupa = roupaRepository.getReferenceById(idRoupa);
		ParteDeCima parteDeCima = roupa.getParteDeCima();
		parteDeCima.setCapuz(dados.getCapuz());
		parteDeCima.setManga(mangaRepository.findyByManga(dados.getManga()));
		parteDeCima.setDecote(decoteRepository.findyByDecote(dados.getDecote()));
		parteDeCima.setCava(cavaRepository.findyByCava(dados.getCava()));
		parteDeCima.setComprimento(comprimentoRepository.findyByComprimento(dados.getComprimento()));
	

		return parteDeCima;
	}


}
