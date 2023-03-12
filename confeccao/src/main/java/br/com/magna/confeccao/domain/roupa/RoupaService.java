package br.com.magna.confeccao.domain.roupa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.modelagem.ModelagemService;
import br.com.magna.confeccao.domain.roupa.partecima.ParteDeCima;
import br.com.magna.confeccao.domain.roupa.partecima.ParteDeCimaService;
import br.com.magna.confeccao.domain.tecido.Tecido;
import br.com.magna.confeccao.domain.tecido.TecidoRepository;
import br.com.magna.confeccao.domain.tecido.TecidoService;

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

	public void criarRoupa(DadosCadastroRoupa dados) {

		Modelagem modelagem = modelagemService.criarModelagem(dados.modelagem());
		Tecido tecido = tecidoService.criarTecido(dados.tecido());
		ParteDeCima parteDeCima = parteDeCimaService.criarParteDeCima(dados.parteDeCima());

		Roupa roupa = new Roupa( 
				dados.nome(), 
				dados.tamanho(), 
				dados.genero(), 
				dados.cor(), 
				dados.temEstampa(),
				dados.temBordado(),
				modelagem,
				tecido,
				parteDeCima
				);

		roupaRepository.save(roupa);

	}

	/*
	 * public List<DadosDetalhamentoRoupa> listagem() { List<DadosDetalhamentoRoupa>
	 * roupas = roupaRepository.findAll().stream().map(DadosDetalhamentoRoupa::new)
	 * .toList();
	 * 
	 * return roupas;
	 * 
	 * }
	 */

	public Page<DadosListagemRoupa> listar(Pageable paginacao) {
		Page<DadosListagemRoupa> page = roupaRepository.findAll(paginacao).map(DadosListagemRoupa::new);
		return page;
	}
	


	public DadosDetalhamentoRoupa atualizar(DadosAtualizaRoupa dados) {
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
			if (dados.tecido().id() != dados.id()) {
				Tecido tecido = tecidoRepository.getReferenceById(dados.tecido().id());
				roupa.setTecido(tecido);
			} else {
				Tecido tecido = tecidoService.atualizaTecido(dados.tecido());
				roupa.setTecido(tecido);
			}
		}

		if (dados.parteDeCima() != null) {
			ParteDeCima parteDeCima = parteDeCimaService.atualizaParteDeCima(dados.id() ,dados.parteDeCima());
			roupa.setParteDeCima(parteDeCima);

		}

		roupaRepository.save(roupa);

		DadosDetalhamentoRoupa dadosDetalhamentoRoupa = new DadosDetalhamentoRoupa(roupa);

		return dadosDetalhamentoRoupa;

	}

	public DadosDetalhamentoRoupa detalharPorId(Long id) {
		Roupa roupa = roupaRepository.getReferenceById(id);

		DadosDetalhamentoRoupa dadosDetalhamentoRoupa = new DadosDetalhamentoRoupa(roupa);

		return dadosDetalhamentoRoupa;
	}

	public void deletar(Long id) {
		Roupa roupa = roupaRepository.getReferenceById(id);

		roupaRepository.delete(roupa);
	}
}
