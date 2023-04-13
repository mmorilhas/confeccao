package br.com.magna.confeccao.service;

import java.time.ZonedDateTime;
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
import br.com.magna.confeccao.entities.roupa.RoupaHistorico;
import br.com.magna.confeccao.entities.roupa.validacoes.cadastro.ValidadorRoupaAtualizar;
import br.com.magna.confeccao.entities.roupa.validacoes.cadastro.ValidadorRoupaCadastro;
import br.com.magna.confeccao.entities.tecido.Tecido;
import br.com.magna.confeccao.entities.tecido.TecidoHistorico;
import br.com.magna.confeccao.repository.RoupaHistRepository;
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
	private RoupaHistRepository roupaHistRepository;
	
	@Autowired
	private List<ValidadorRoupaCadastro> validadoresCadastro;
	
	
	@Autowired
	private List<ValidadorRoupaAtualizar> validadoresAtualizar;
	

	public void criarRoupaECadastrar(@Valid DadosCadastroRoupaDTO dados) {

		validadoresCadastro.forEach(v -> v.validarCadastro(dados));
		
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
		roupa.setUser_first_insert("admin");
		roupa.setUser_last_modified("admin");
		
		
		tecido.setTimeStamp(ZonedDateTime.now());
		roupa.setTimeStamp(ZonedDateTime.now());
		
		RoupaHistorico roupaHistorico = criaRoupaHistorico(roupa);
		roupaRepository.save(roupa);
		roupaHistRepository.save(roupaHistorico);
		
		

	}

	public Page<DadosListagemRoupaDTO> listar(Pageable paginacao) {
		return roupaRepository.findAllByAtivoTrue(paginacao).map(DadosListagemRoupaDTO::new);
	}

	public DadosDetalhamentoRoupaDTO atualizar(@Valid DadosAtualizaRoupaDTO dados) {
		
		Roupa roupa = roupaRepository.getReferenceById(dados.getId());
		
		RoupaHistorico roupaHistorico = criaRoupaHistorico(roupa);
		roupaHistRepository.save(roupaHistorico);
		
		validadoresAtualizar.forEach(v -> v.validarAtualiza(dados));
		

		roupa.setNome(dados.getNome());
		roupa.setTipoRoupa(tipoRoupaRepository.getReferenceById(dados.getTipoRoupa()));
		roupa.setTamanho(dados.getTamanho());
		roupa.setGenero(dados.getGenero());
		roupa.setCor(dados.getCor());
		roupa.setTemEstampa(dados.getTemEstampa());
		roupa.setTemBordado(dados.getTemBordado());
		roupa.setUser_first_insert("admin");
		roupa.setUser_last_modified("admin");
		

		if (dados.getModelagem() != null) {
			Modelagem modelagem = modelagemService.atualizaModelagem(dados.getId(), dados.getModelagem());
			roupa.setModelagem(modelagem);
		}

		if (dados.getTecido() != null) {
			Tecido tecido = tecidoService.atualizaTecido(dados.getId(), dados.getTecido());
			roupa.setTecido(tecido);
			tecido.setUser_first_insert("admin");
			tecido.setUser_last_modified("admin");	
			tecido.setTimeStamp(ZonedDateTime.now());
		}

		if (dados.getParteDeCima() != null) {
			ParteDeCima parteDeCima = parteDeCimaService.atualizaParteDeCima(dados.getId(), dados.getParteDeCima());
			roupa.setParteDeCima(parteDeCima);
		}

		roupa.setTimeStamp(ZonedDateTime.now());

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
		TecidoHistorico tecidoHistorico = new TecidoHistorico();
		tecidoHistorico.setId(tecido.getId());
		tecidoHistorico.setComposicao(tecido.getComposicao());
		tecidoHistorico.setConstrucao(tecido.getConstrucao());
		tecidoHistorico.setTipoDeTecido(tecido.getTipoDeTecido());
		tecidoHistorico.setTempoSecagem(tecido.getTempoSecagem());
		tecidoHistorico.setRespiravel(tecido.getRespiravel());
		tecidoHistorico.setAbsorcaoAgua(tecido.getAbsorcaoAgua());
		tecidoHistorico.setElasticidade(tecido.getElasticidade());
		tecidoHistorico.setComportamentoTermico(tecido.getComportamentoTermico());
		tecidoHistorico.setResistencia(tecido.getResistencia());
		tecidoHistorico.setUser_first_insert(tecido.getUser_first_insert());
		tecidoHistorico.setUser_last_modified(tecido.getUser_last_modified());
		tecidoHistorico.setTimeStamp(tecido.getTimeStamp());
		
		return tecidoHistorico;
		
	}
	
	private RoupaHistorico criaRoupaHistorico(Roupa roupa) {
		RoupaHistorico roupaHistorico = new RoupaHistorico();
		roupaHistorico.setId(roupa.getId());
		roupaHistorico.setNome(roupa.getNome());
		roupaHistorico.setTipoRoupa(roupa.getTipoRoupa());
		roupaHistorico.setTamanho(roupa.getTamanho());
		roupaHistorico.setGenero(roupa.getGenero());
		roupaHistorico.setCor(roupa.getCor());
		roupaHistorico.setTemEstampa(roupa.getTemEstampa());
		roupaHistorico.setTemBordado(roupa.getTemBordado());
		roupaHistorico.setModelagem(roupa.getModelagem());
		roupaHistorico.setTecido(criaTecidoHistorico(roupa.getTecido()));
		roupaHistorico.setParteDeCima(roupa.getParteDeCima());
		roupaHistorico.setAtivo(roupa.getAtivo());
		roupaHistorico.setUser_first_insert(roupa.getUser_first_insert());
		roupaHistorico.setUser_last_modified(roupa.getUser_last_modified());
		roupaHistorico.setTimeStamp(roupa.getTimeStamp());
		
		return roupaHistorico;
		
		
	}
	
	
}
