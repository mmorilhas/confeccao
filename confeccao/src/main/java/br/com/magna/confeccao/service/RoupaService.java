package br.com.magna.confeccao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.partecima.ParteDeCima;
import br.com.magna.confeccao.domain.roupa.Roupa;
import br.com.magna.confeccao.domain.tecido.Tecido;
import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.dto.DadosDetalhamentoRoupaDTO;
import br.com.magna.confeccao.dto.DadosListagemRoupaDTO;
import br.com.magna.confeccao.repository.RoupaRepository;
import br.com.magna.confeccao.repository.TecidoRepository;
import jakarta.validation.Valid;

@Service
public class RoupaService {

	@Autowired
	private TecidoService tecidoService;
	@Autowired
	private ModelagemService modelagemService;
	@Autowired
	private TecidoRepository tecidoRepository;
	@Autowired
	private ParteDeCimaService parteDeCimaService;

	@Autowired
	private RoupaRepository roupaRepository;

	public void criarRoupaECadastrar(@Valid DadosCadastroRoupaDTO dados) {

		Modelagem modelagem = modelagemService.criarModelagem(dados.modelagem());
		Tecido tecido = tecidoService.criarTecido(dados.tecido());
		ParteDeCima parteDeCima = parteDeCimaService.criarParteDeCima(dados.parteDeCima());

		Roupa roupa = new Roupa();
		roupa.setNome(dados.nome());
		roupa.setTamanho(dados.tamanho());
		roupa.setGenero(dados.genero());
		roupa.setCor(dados.cor());
		roupa.setTemEstampa(dados.temEstampa());
		roupa.setTemBordado(dados.temBordado());
		roupa.setModelagem(modelagem);
		roupa.setTecido(tecido);
		roupa.setParteDeCima(parteDeCima);
		roupa.setAtivo(true);
	

		roupaRepository.save(roupa);

	}

	public Page<DadosListagemRoupaDTO> listar(Pageable paginacao) {
		return roupaRepository.findAllByAtivoTrue(paginacao).map(DadosListagemRoupaDTO::new);
	}

	public DadosDetalhamentoRoupaDTO atualizar(@Valid DadosAtualizaRoupaDTO dados) {
		Roupa roupa = roupaRepository.getReferenceById(dados.id());

		if (dados.nome() != null) {
			roupa.setNome(dados.nome());
		}
		if (dados.tamanho() != null) {
			roupa.setTamanho(dados.tamanho());
		}
		if (dados.genero() != null) {
			roupa.setGenero(dados.genero());
		}
		if (dados.cor() != null) {
			roupa.setCor(dados.cor());
		}
		if (dados.temEstampa() != null) {
			roupa.setTemEstampa(dados.temEstampa());
		}
		if (dados.temBordado() != null) {
			roupa.setTemBordado(dados.temBordado());
		}

		if (dados.modelagem() != null) {
			Modelagem modelagem = modelagemService.atualizaModelagem(dados.id(), dados.modelagem());
			roupa.setModelagem(modelagem);

		}

		if (dados.tecido() != null) {
			if (!dados.tecido().id().equals(dados.id())) {
				Tecido tecido = tecidoRepository.getReferenceById(dados.tecido().id());
				roupa.setTecido(tecido);
			} else {
				Tecido tecido = tecidoService.atualizaTecido(dados.tecido());
				roupa.setTecido(tecido);
			}
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
}
