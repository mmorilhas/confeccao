package br.com.magna.confeccao.domain.roupa.partecima;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.modelagem.ModelagemService;
import br.com.magna.confeccao.domain.roupa.DadosCadastroRoupa;
import br.com.magna.confeccao.domain.roupa.DadosListagemRoupa;
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
	
	public List<DadosListagemRoupa> listagem() {
		List<DadosListagemRoupa> roupas = roupaRepository.findAll().stream().map(DadosListagemRoupa::new).toList();
		
		return roupas;
		
	}
}
