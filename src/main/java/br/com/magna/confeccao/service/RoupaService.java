package br.com.magna.confeccao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.dto.DadosDetalhamentoRoupaDTO;
import br.com.magna.confeccao.dto.DadosListagemRoupaDTO;
import br.com.magna.confeccao.entities.modelagem.Modelagem;
import br.com.magna.confeccao.entities.partecima.ParteDeCima;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.entities.roupa.validacoes.ValidadorRoupaCadastro;
import br.com.magna.confeccao.entities.tecido.Tecido;
import br.com.magna.confeccao.repository.RoupaRepository;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;
import jakarta.validation.Valid;

@Service
public class RoupaService {

	@Autowired
	private TecidoService tecidoService;
	@Autowired
	private ModelagemService modelagemService;
	@Autowired
	private ParteDeCimaService parteDeCimaService;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaRepository;

	@Autowired
	private RoupaRepository roupaRepository;
	
	@Autowired
	private List<ValidadorRoupaCadastro> validadoresCadastro;
	

	public void criarRoupaECadastrar(@Valid DadosCadastroRoupaDTO dados) {

		validadoresCadastro.forEach(v -> v.validar(dados));
		
		Modelagem modelagem = modelagemService.criarModelagem(dados.getModelagem());
		Tecido tecido = tecidoService.criarTecido(dados.getTecido());
		ParteDeCima parteDeCima = parteDeCimaService.criarParteDeCima(dados.getParteDeCima());

		Roupa roupa = new Roupa();
		roupa.setNome(dados.getNome());
		roupa.setTipoRoupa(tipoRoupaRepository.getReferenceById(dados.getTipoRoupa()));
		roupa.setTamanho(dados.getTamanho());
		roupa.setGenero(dados.getGenero());
		roupa.setCor(dados.getCor());
		roupa.setTemEstampa(dados.getTemEstampa());
		roupa.setTemBordado(dados.getTemBordado());
		roupa.setModelagem(modelagem);
		roupa.setTecido(tecido);
		roupa.setParteDeCima(parteDeCima);
		roupa.setAtivo();

		roupaRepository.save(roupa);

	}

	public Page<DadosListagemRoupaDTO> listar(Pageable paginacao) {
		return roupaRepository.findAllByAtivoTrue(paginacao).map(DadosListagemRoupaDTO::new);
	}

	public DadosDetalhamentoRoupaDTO atualizar(@Valid DadosAtualizaRoupaDTO dados) {
		
		Roupa roupa = roupaRepository.getReferenceById(dados.getId());

		roupa.setNome(dados.getNome());
		roupa.setTipoRoupa(tipoRoupaRepository.getReferenceById(dados.getTipoRoupa()));
		roupa.setTamanho(dados.getTamanho());
		roupa.setGenero(dados.getGenero());
		roupa.setCor(dados.getCor());
		roupa.setTemEstampa(dados.getTemEstampa());
		roupa.setTemBordado(dados.getTemBordado());

		if (dados.getModelagem() != null) {
			Modelagem modelagem = modelagemService.atualizaModelagem(dados.getId(), dados.getModelagem());
			roupa.setModelagem(modelagem);
		}

		if (dados.getTecido() != null) {
			Tecido tecido = tecidoService.atualizaTecido(dados.getId(), dados.getTecido());
			roupa.setTecido(tecido);
		}

		if (dados.getParteDeCima() != null) {
			ParteDeCima parteDeCima = parteDeCimaService.atualizaParteDeCima(dados.getId(), dados.getParteDeCima());
			roupa.setParteDeCima(parteDeCima);
		}

		roupaRepository.save(roupa);

		return new DadosDetalhamentoRoupaDTO(roupa);

	}

	public DadosDetalhamentoRoupaDTO detalharPorId(Long id) {
		Roupa roupa = roupaRepository.getReferenceById(id);
		return new DadosDetalhamentoRoupaDTO(roupa);
	}

	public void tornarInativo(Long id) {
		Roupa roupa = roupaRepository.getReferenceById(id);
		roupa.excluir();
	}
	
}
