package br.com.magna.confeccao.domain.modelagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelagemService {

	@Autowired ModelagemRepository modelagemRepository;
	@Autowired FechamentoRepository fechamentoRepository;
	@Autowired BarraRepository barraRepository;
	@Autowired SilhuetaRepository silhuetaRepository;
	@Autowired PregaRepository pregaRepository;
	
	public Modelagem criarModelagem(DadosCadastroModelagem dados) {
		Silhueta silhueta = null;
		Fechamento fechamento = null;
		Barra barra = null;
		Prega prega = null;
		
		if(fechamentoRepository.existsById(dados.idFechamento())) {
			fechamento = fechamentoRepository.getReferenceById(dados.idFechamento());
		}
		
		if(barraRepository.existsById(dados.idBarra())) {
			barra = barraRepository.getReferenceById(dados.idBarra());
		}
		
		if(silhuetaRepository.existsById(dados.idSilhueta())) {
			silhueta = silhuetaRepository.getReferenceById(dados.idSilhueta());
		}
		if(pregaRepository.existsById(dados.idPrega())) {
			prega = pregaRepository.getReferenceById(dados.idPrega());
		}
		
		
		Modelagem modelagem = new Modelagem(null, dados.bolsos(), fechamento, barra, dados.pala(), prega, dados.pences(), dados.fenda(), dados.forro(), dados.babado(), dados.cinto(), dados.passantes(), silhueta );
		
		
		return modelagem;
		
	}
	
}
