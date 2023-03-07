package br.com.magna.confeccao.domain.modelagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.roupa.DadosDetalhamentoRoupa;

@Service
public class ModelagemService {

	@Autowired
	ModelagemRepository modelagemRepository;
	@Autowired
	FechamentoRepository fechamentoRepository;
	@Autowired
	BarraRepository barraRepository;
	@Autowired
	SilhuetaRepository silhuetaRepository;
	@Autowired
	PregaRepository pregaRepository;

	public Modelagem criarModelagem(DadosCadastroModelagem dados) {
		Silhueta silhueta = null;
		Fechamento fechamento = null;
		Barra barra = null;
		Prega prega = null;

		if (fechamentoRepository.existsById(dados.idFechamento())) {
			fechamento = fechamentoRepository.getReferenceById(dados.idFechamento());
		}

		if (barraRepository.existsById(dados.idBarra())) {
			barra = barraRepository.getReferenceById(dados.idBarra());
		}

		if (silhuetaRepository.existsById(dados.idSilhueta())) {
			silhueta = silhuetaRepository.getReferenceById(dados.idSilhueta());
		}
		if (pregaRepository.existsById(dados.idPrega())) {
			prega = pregaRepository.getReferenceById(dados.idPrega());
		}

		Modelagem modelagem = new Modelagem(null, dados.bolsos(), fechamento, barra, dados.pala(), prega,
				dados.pences(), dados.fenda(), dados.forro(), dados.babado(), dados.cinto(), dados.passantes(),
				silhueta);

		return modelagem;

	}

	public Modelagem atualizaModelagem(DadosAtualizaModelagem dados) {
		Modelagem modelagem = modelagemRepository.getReferenceById(dados.id());
		


		if (dados.idSilhueta() != null) {
			Silhueta silhueta = verificaSilhueta(dados.idSilhueta());
			modelagem.setSilhueta(silhueta);
		}
		if (dados.idFechamento() != null) {
			Fechamento fechamento = verifcaFechamento(dados.idFechamento());
			modelagem.setFechamento(fechamento);
		}
		if (dados.idPrega() != null) {
			Prega prega = verificaPrega(dados.idPrega());
			modelagem.setPrega(prega);
		}
		if (dados.idBarra() != null) {
			Barra barra = verificaBarra(dados.idBarra());
			modelagem.setBarra(barra);
		}
		if(dados.cinto() != null) {
			modelagem.setCinto(dados.cinto());
		}
		if(dados.passantes() != null) {
			modelagem.setPassantes(dados.passantes());
		}
		if(dados.pences() != null) {
			modelagem.setPences(dados.pences());
		}
		if(dados.pala() != null) {
			modelagem.setPala(dados.pala());
		}
		if(dados.babado() != null) {
			modelagem.setBabado(dados.babado());
		}
		if(dados.fenda() != null) {
			modelagem.setFenda(dados.fenda());
		}
		if(dados.bolsos() != null) {
			modelagem.setBolsos(dados.bolsos());
		}
		if(dados.forro() != null) {
			modelagem.setForro(dados.forro());
		}
		

		modelagemRepository.save(modelagem);
		
		return modelagem;
	}

	public Silhueta verificaSilhueta(Long idSilhueta) {
		if (!silhuetaRepository.existsById(idSilhueta)) {
			throw new RuntimeException();
		}

		Silhueta silhueta = silhuetaRepository.getReferenceById(idSilhueta);

		return silhueta;
	}

	public Fechamento verifcaFechamento(Long idFechamento) {
		if (!fechamentoRepository.existsById(idFechamento)) {
			throw new RuntimeException();
		}

		Fechamento fechamento = fechamentoRepository.getReferenceById(idFechamento);

		return fechamento;
	}

	private Barra verificaBarra(Long idBarra) {
		if (!barraRepository.existsById(idBarra)) {
			throw new RuntimeException();
		}
		Barra barra = barraRepository.getReferenceById(idBarra);
		;

		return barra;
	}

	private Prega verificaPrega(Long idPrega) {
		if (!pregaRepository.existsById(idPrega)) {
			throw new RuntimeException();
		}

		Prega prega = pregaRepository.getReferenceById(idPrega);
		return prega;
	}
}
