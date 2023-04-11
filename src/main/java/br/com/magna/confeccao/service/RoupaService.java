package br.com.magna.confeccao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.dto.DadosDetalhamentoRoupaDTO;
import br.com.magna.confeccao.dto.domain.DadosListagemRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.modelagem.SilhuetaDomain;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.entities.modelagem.Modelagem;
import br.com.magna.confeccao.entities.partecima.ParteDeCima;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.entities.roupa.validacoes.ValidadorRoupa;
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
	private List<ValidadorRoupa> validadores;

	public void criarRoupaECadastrar(@Valid DadosCadastroRoupaDTO dados) {

		validadores.forEach(v -> v.validar(dados));
		
		Modelagem modelagem = modelagemService.criarModelagem(dados.modelagem());
		Tecido tecido = tecidoService.criarTecido(dados.tecido());
		ParteDeCima parteDeCima = parteDeCimaService.criarParteDeCima(dados.parteDeCima());

		Roupa roupa = new Roupa();
		roupa.setNome(dados.nome());
		roupa.setTipoRoupa(verificaEPegaTipoRoupa(dados.tipoRoupa()));
		roupa.setTamanho(dados.tamanho());
		roupa.setGenero(dados.genero());
		roupa.setCor(dados.cor());
		roupa.setTemEstampa(dados.temEstampa());
		roupa.setTemBordado(dados.temBordado());
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
		Roupa roupa = roupaRepository.getReferenceById(dados.id());

		roupa.setNome(dados.nome());
		roupa.setTipoRoupa(verificaEPegaTipoRoupa(dados.tipoRoupa()));
		roupa.setTamanho(dados.tamanho());
		roupa.setGenero(dados.genero());
		roupa.setCor(dados.cor());
		roupa.setTemEstampa(dados.temEstampa());
		roupa.setTemBordado(dados.temBordado());

		if (dados.modelagem() != null) {
			Modelagem modelagem = modelagemService.atualizaModelagem(dados.id(), dados.modelagem());
			roupa.setModelagem(modelagem);
		}

		if (dados.tecido() != null) {
			Tecido tecido = tecidoService.atualizaTecido(dados.id(), dados.tecido());
			roupa.setTecido(tecido);
		}

		if (dados.parteDeCima() != null) {
			ParteDeCima parteDeCima = parteDeCimaService.atualizaParteDeCima(dados.id(), dados.parteDeCima());
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
	
	private TipoRoupaDomain verificaEPegaTipoRoupa(String tipoRoupa) {
		if (!tipoRoupaRepository.existsById(tipoRoupa)) {
			throw new ValidacaoException("Id de TipoRoupa informado não existe");
		}
		

		return tipoRoupaRepository.getReferenceById(tipoRoupa);
	}
}
