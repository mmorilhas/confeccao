package br.com.magna.confeccao.service;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.dto.DadosDetalhamentoRoupaDTO;
import br.com.magna.confeccao.dto.DadosListagemRoupaDTO;
import br.com.magna.confeccao.entities.domain.fibra.FibraDomain;
import br.com.magna.confeccao.entities.modelagem.Modelagem;
import br.com.magna.confeccao.entities.partecima.ParteDeCima;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.entities.roupa.RoupaHistorico;
import br.com.magna.confeccao.entities.roupa.validacoes.ValidadorRoupaAtualizar;
import br.com.magna.confeccao.entities.roupa.validacoes.ValidadorRoupaCadastro;
import br.com.magna.confeccao.entities.roupa.validacoes.modelagem.ValidadorModelagem;
import br.com.magna.confeccao.entities.roupa.validacoes.partecima.ValidadorParteCima;
import br.com.magna.confeccao.entities.roupa.validacoes.tecido.ValidadorTecido;
import br.com.magna.confeccao.entities.tecido.Tecido;
import br.com.magna.confeccao.entities.tecido.TecidoHistorico;
import br.com.magna.confeccao.repository.RoupaHistRepository;
import br.com.magna.confeccao.repository.RoupaRepository;
import br.com.magna.confeccao.repository.domain.TipoRoupaDomainRepository;
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
	private RoupaHistRepository roupaHistRepository;
	
	@Autowired
	private List<ValidadorTecido> validadoresTecido;
	
	@Autowired
	private List<ValidadorModelagem> validadoresModelagem;
	
	@Autowired
	private List<ValidadorParteCima> validadoresParteCima;
	
	@Autowired
	private List<ValidadorRoupaCadastro> validadoresRoupaCadastro;
	
	@Autowired
	private List<ValidadorRoupaAtualizar> validadoresRoupaAtualizar;
	
	
	private String user = "admin";

	public void criarRoupaECadastrar(@Valid DadosCadastroRoupaDTO dados) {
		
		validadoresTecido.forEach(v -> v.validar(dados.getTecido()));
		validadoresModelagem.forEach(v -> v.validar(dados.getModelagem()));
		validadoresParteCima.forEach(v -> v.validar(dados.getParteDeCima()));
		validadoresRoupaCadastro.forEach(v -> v.validarCadastro(dados));
		
		Modelagem modelagem = modelagemService.criarModelagem(dados.getModelagem());
		Tecido tecido = tecidoService.criarTecido(dados.getTecido());
		ParteDeCima parteDeCima = parteDeCimaService.criarParteDeCima(dados.getParteDeCima());

		  
		Roupa roupa = new Roupa();
		roupa.setNome(dados.getNome());
		roupa.setColecao(dados.getColecao());
		roupa.setTipoRoupa(tipoRoupaRepository.findByTipoRoupa(dados.getTipoRoupa()));
		roupa.setTamanhoInicial(dados.getTamanhoInicial());
		roupa.setTamanhoFinal(dados.getTamanhoFinal());
		roupa.setGenero(dados.getGenero());
		roupa.setCor(dados.getCor());
		roupa.setTemEstampa(dados.getTemEstampa());
		roupa.setTemBordado(dados.getTemBordado());
		roupa.setModelagem(modelagem);
		roupa.setTecido(tecido);
		roupa.setParteDeCima(parteDeCima);
		roupa.setAtivo();
		
		
		roupa.setUserFirstInsert(user);
		roupa.setUserLastModified(user);
		
		tecido.setTimeStampFirstInsert(ZonedDateTime.now());
		roupa.setTimeStampFirstInsert(ZonedDateTime.now());
		tecido.setTimeStampLastModified(ZonedDateTime.now());
		roupa.setTimeStampLastModified(ZonedDateTime.now());
		
		roupaRepository.save(roupa);
		
		RoupaHistorico roupaHistorico = criaRoupaHistorico(roupa);
		roupaHistRepository.save(roupaHistorico);

	}

	public Page<DadosListagemRoupaDTO> listar(Pageable paginacao) {
		return roupaRepository.findAllByAtivoTrue(paginacao).map(DadosListagemRoupaDTO::new);
	}
	
	public Page<DadosListagemRoupaDTO> listarPorColecao(Pageable paginacao, String colecao) {
		return roupaRepository.findAllByColecao(paginacao, colecao).map(DadosListagemRoupaDTO::new);
	}
	

	public DadosDetalhamentoRoupaDTO atualizar(@Valid DadosAtualizaRoupaDTO dados) {
		
		Roupa roupa = roupaRepository.getReferenceById(dados.getId());
		
		RoupaHistorico roupaHistorico = criaRoupaHistorico(roupa);
		roupaHistRepository.save(roupaHistorico);
		
		
		validadoresTecido.forEach(v -> v.validar(dados.getTecido()));
		validadoresModelagem.forEach(v -> v.validar(dados.getModelagem()));
		validadoresParteCima.forEach(v -> v.validar(dados.getParteDeCima()));
		validadoresRoupaAtualizar.forEach(v -> v.validarAtualiza(dados));
		

		roupa.setNome(dados.getNome());
		roupa.setColecao(dados.getColecao());
		roupa.setTipoRoupa(tipoRoupaRepository.findByTipoRoupa(dados.getTipoRoupa()));
		roupa.setTamanhoInicial(dados.getTamanhoInicial());
		roupa.setTamanhoFinal(dados.getTamanhoFinal());
		roupa.setGenero(dados.getGenero());
		roupa.setCor(dados.getCor());
		roupa.setTemEstampa(dados.getTemEstampa());
		roupa.setTemBordado(dados.getTemBordado());
		roupa.setUserFirstInsert(user);
		roupa.setUserLastModified(user);
		

		if (dados.getModelagem() != null) {
			Modelagem modelagem = modelagemService.atualizaModelagem(dados.getId(), dados.getModelagem());
			roupa.setModelagem(modelagem);
		}

		if (dados.getTecido() != null) {
			Tecido tecido = tecidoService.atualizaTecido(dados.getId(), dados.getTecido());
			roupa.setTecido(tecido);
			tecido.setUserLastModified(user);	
			tecido.setTimeStampLastModified(ZonedDateTime.now());
		}

		if (dados.getParteDeCima() != null) {
			ParteDeCima parteDeCima = parteDeCimaService.atualizaParteDeCima(dados.getId(), dados.getParteDeCima());
			roupa.setParteDeCima(parteDeCima);
		}

		roupa.setTimeStampLastModified(ZonedDateTime.now());

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
	
	
	
	private TecidoHistorico criaTecidoHistorico(Tecido tecido) {
		Collection<FibraDomain> composicao = new HashSet<>(tecido.getComposicao());
		
		
		
		TecidoHistorico tecidoHistorico = new TecidoHistorico();
		tecidoHistorico.setIdTecido(tecido.getId());
		tecidoHistorico.setComposicao(composicao);
		tecidoHistorico.setConstrucao(tecido.getConstrucao());
		tecidoHistorico.setTipoDeTecido(tecido.getTipoDeTecido());
		tecidoHistorico.setTempoSecagem(tecido.getTempoSecagem());
		tecidoHistorico.setRespiravel(tecido.getRespiravel());
		tecidoHistorico.setAbsorcaoAgua(tecido.getAbsorcaoAgua());
		tecidoHistorico.setElasticidade(tecido.getElasticidade());
		tecidoHistorico.setComportamentoTermico(tecido.getComportamentoTermico());
		tecidoHistorico.setResistencia(tecido.getResistencia());
		
		tecidoHistorico.setUserFirstInsert(tecido.getUserFirstInsert());
		tecidoHistorico.setUserLastModified(tecido.getUserLastModified());
		tecidoHistorico.setTimeStampFirstInsert(tecido.getTimeStampLastModified());
		tecidoHistorico.setTimeStampLastModified(tecido.getTimeStampLastModified());
		
		return tecidoHistorico;
		
	}
	
	private RoupaHistorico criaRoupaHistorico(Roupa roupa) {
		RoupaHistorico roupaHistorico = new RoupaHistorico();
		
		
		
		roupaHistorico.setIdRoupa(roupa.getId());
		roupaHistorico.setNome(roupa.getNome());
		roupaHistorico.setColecao(roupa.getColecao());
		roupaHistorico.setTipoRoupa(roupa.getTipoRoupa());
		roupaHistorico.setTamanhoInicial(roupa.getTamanhoInicial());
		roupaHistorico.setTamanhoFinal(roupa.getTamanhoFinal());
		roupaHistorico.setGenero(roupa.getGenero());
		roupaHistorico.setCor(roupa.getCor());
		roupaHistorico.setTemEstampa(roupa.getTemEstampa());
		roupaHistorico.setTemBordado(roupa.getTemBordado());
		roupaHistorico.setModelagem(roupa.getModelagem());
		roupaHistorico.setTecido(criaTecidoHistorico(roupa.getTecido()));
		roupaHistorico.setParteDeCima(roupa.getParteDeCima());
		roupaHistorico.setAtivo(roupa.getAtivo());
		
		
		roupaHistorico.setUserFirstInsert(roupa.getUserFirstInsert());
		roupaHistorico.setUserLastModified(roupa.getUserLastModified());
		roupaHistorico.setTimeStampFirstInsert(roupa.getTimeStampfirstInsert());
		roupaHistorico.setTimeStampLastModified(roupa.getTimeStampLastModified());
		
		return roupaHistorico;
		
		
	}
	
	
}
