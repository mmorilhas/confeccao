package br.com.magna.confeccao.domain.roupa.partecima;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.modelagem.ModelagemService;
import br.com.magna.confeccao.domain.roupa.DadosAtualizaRoupa;
import br.com.magna.confeccao.domain.roupa.DadosCadastroRoupa;
import br.com.magna.confeccao.domain.roupa.DadosDetalhamentoRoupa;
import br.com.magna.confeccao.domain.roupa.Roupa;
import br.com.magna.confeccao.domain.roupa.RoupaRepository;
import br.com.magna.confeccao.domain.tecido.Tecido;
import br.com.magna.confeccao.domain.tecido.TecidoService;

@Service
public class RoupaService {

	
	@Autowired private TecidoService tecidoService;
	@Autowired private ModelagemService modelagemService;
	@Autowired private ParteDeCimaService parteDeCimaService;
	
	@Autowired private RoupaRepository roupaRepository;
	
	public void criarRoupa(DadosCadastroRoupa dados) {
		
		Modelagem modelagem = modelagemService.criarModelagem(dados.modelagem());
		Tecido tecido = tecidoService.criarTecido(dados.tecido());
		ParteDeCima parteDeCima = parteDeCimaService.criarParteDeCima(dados.parteDeCima());

		Roupa roupa = new Roupa(null, dados.nome(), dados.tamanho(), dados.genero(), dados.cor(), modelagem, dados.temEstampa(), dados.temBordado(), tecido, parteDeCima);	
		
		roupaRepository.save(roupa);
		
	}
	
	public List<DadosDetalhamentoRoupa> listagem() {
		List<DadosDetalhamentoRoupa> roupas = roupaRepository.findAll().stream().map(DadosDetalhamentoRoupa::new).toList();
		
		return roupas;
		
	}
	
	public DadosDetalhamentoRoupa atualizar(DadosAtualizaRoupa dados) {
		Roupa roupa = roupaRepository.getReferenceById(dados.id());
		
		if(dados.nome() != null) {
			roupa.setNome(dados.nome());
		}
		if(dados.tamanho() != null) {
			roupa.setTamanho(dados.tamanho());
		}
		if(dados.genero() != null) {
			roupa.setGenero(dados.genero());
		}
		if(dados.cor() != null) {
			roupa.setCor(dados.cor());
		}
		if(dados.temEstampa() != null) {
			roupa.setTemEstampa(dados.temEstampa());
		}
		if(dados.temBordado() != null) {
			roupa.setTemBordado(dados.temBordado());
		}
		
		if(dados.modelagem() != null) {
			Modelagem modelagem = modelagemService.atualizaModelagem(dados.modelagem());
			roupa.setModelagem(modelagem);
		}
		
		if(dados.tecido() != null) {
			Tecido tecido = tecidoService.atualizaTecido(dados.tecido());
			roupa.setTecido(tecido);
		}
		
		if(dados.parteDeCima() != null) {
			ParteDeCima parteDeCima = parteDeCimaService.atualizaParteDeCima(dados.parteDeCima());
			roupa.setParteDeCima(parteDeCima);

		}
		
		roupaRepository.save(roupa);
		
		DadosDetalhamentoRoupa dadosDetalhamentoRoupa = new DadosDetalhamentoRoupa(roupa);
		
		return dadosDetalhamentoRoupa;
			
	}
}
