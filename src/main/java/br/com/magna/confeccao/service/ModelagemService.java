package br.com.magna.confeccao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.modelagem.BarraDomain;
import br.com.magna.confeccao.entities.domain.modelagem.FechamentoDomain;
import br.com.magna.confeccao.entities.domain.modelagem.PregaDomain;
import br.com.magna.confeccao.entities.domain.modelagem.SilhuetaDomain;
import br.com.magna.confeccao.entities.modelagem.Modelagem;
import br.com.magna.confeccao.entities.modelagem.validacoes.ValidadorModelagem;
import br.com.magna.confeccao.entities.partecima.validacoes.ValidadorParteCima;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.repository.BarraDomainRepository;
import br.com.magna.confeccao.repository.FechamentoDomainRepository;
import br.com.magna.confeccao.repository.PregaDomainRepository;
import br.com.magna.confeccao.repository.RoupaRepository;
import br.com.magna.confeccao.repository.SilhuetaDomainRepository;
import jakarta.validation.Valid;

@Service
public class ModelagemService {

	@Autowired
	private FechamentoDomainRepository fechamentoRepository;
	@Autowired
	private BarraDomainRepository barraRepository;
	@Autowired
	private SilhuetaDomainRepository silhuetaRepository;
	@Autowired
	private PregaDomainRepository pregaRepository;
	@Autowired
	private RoupaRepository roupaRepository;
	
	@Autowired
	private List<ValidadorModelagem> validadores;

	public Modelagem criarModelagem(@Valid DadosCadastroModelagemDTO dados) {
		
		validadores.forEach(v -> v.validar(dados));
		
		Modelagem modelagem = new Modelagem();
		modelagem.setSilhueta(silhuetaRepository.getReferenceById(dados.getIdSilhueta()));
		modelagem.setFechamento(fechamentoRepository.getReferenceById(dados.getIdFechamento()));
		modelagem.setCinto(dados.getCinto());
		modelagem.setPassantes(dados.getPassantes());
		modelagem.setPences(dados.getPences());
		modelagem.setPala(dados.getPala());
		modelagem.setPrega(pregaRepository.getReferenceById(dados.getIdPrega()));
		modelagem.setBabado(dados.getBabado());
		modelagem.setFenda(dados.getFenda());
		modelagem.setBolsos(dados.getBolsos());
		modelagem.setForro(dados.getForro());
		modelagem.setBarra(barraRepository.getReferenceById(dados.getIdBarra()));

		return modelagem;

	}

	public Modelagem atualizaModelagem(Long idRoupa, @Valid DadosCadastroModelagemDTO dados) {
		
		validadores.forEach(v -> v.validar(dados));
		
		Roupa roupa = roupaRepository.getReferenceById(idRoupa);
		Modelagem modelagem = roupa.getModelagem();

		modelagem.setSilhueta(silhuetaRepository.getReferenceById(dados.getIdSilhueta()));
		modelagem.setFechamento(fechamentoRepository.getReferenceById(dados.getIdFechamento()));
		modelagem.setPrega(pregaRepository.getReferenceById(dados.getIdPrega()));
		modelagem.setBarra(barraRepository.getReferenceById(dados.getIdBarra()));
		modelagem.setCinto(dados.getCinto());
		modelagem.setPassantes(dados.getPassantes());
		modelagem.setPences(dados.getPences());
		modelagem.setPala(dados.getPala());
		modelagem.setBabado(dados.getBabado());
		modelagem.setFenda(dados.getFenda());
		modelagem.setBolsos(dados.getBolsos());
		modelagem.setForro(dados.getForro());

		return modelagem;
	}

}
