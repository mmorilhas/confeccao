package br.com.magna.confeccao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.entities.modelagem.Modelagem;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.repository.RoupaRepository;
import br.com.magna.confeccao.repository.domain.BarraDomainRepository;
import br.com.magna.confeccao.repository.domain.FechamentoDomainRepository;
import br.com.magna.confeccao.repository.domain.PregaDomainRepository;
import br.com.magna.confeccao.repository.domain.SilhuetaDomainRepository;
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
	

	public Modelagem criarModelagem(@Valid DadosCadastroModelagemDTO dados) {
		
		Modelagem modelagem = new Modelagem();
		modelagem.setSilhueta(silhuetaRepository.findyBySilhueta(dados.getSilhueta()));
		modelagem.setFechamento(fechamentoRepository.findyByFechamento(dados.getFechamento()));
		modelagem.setCinto(dados.getCinto());
		modelagem.setPassantes(dados.getPassantes());
		modelagem.setPences(dados.getPences());
		modelagem.setPala(dados.getPala());
		modelagem.setPrega(pregaRepository.findyByPrega(dados.getPrega()));
		modelagem.setBabado(dados.getBabado());
		modelagem.setFenda(dados.getFenda());
		modelagem.setBolsos(dados.getBolsos());
		modelagem.setForro(dados.getForro());
		modelagem.setBarra( barraRepository.findyByBarra(dados.getBarra()));
		

		return modelagem;

	}

	public Modelagem atualizaModelagem(Long idRoupa, @Valid DadosCadastroModelagemDTO dados) {
		
		Roupa roupa = roupaRepository.getReferenceById(idRoupa);
		Modelagem modelagem = roupa.getModelagem();
		modelagem.setSilhueta(silhuetaRepository.findyBySilhueta(dados.getSilhueta()));
		modelagem.setFechamento(fechamentoRepository.findyByFechamento(dados.getFechamento()));
		modelagem.setPrega(pregaRepository.findyByPrega(dados.getPrega()));
		modelagem.setBarra( barraRepository.findyByBarra(dados.getBarra()));
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
