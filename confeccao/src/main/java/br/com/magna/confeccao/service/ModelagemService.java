package br.com.magna.confeccao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.domain.modelagem.Barra;
import br.com.magna.confeccao.domain.modelagem.Fechamento;
import br.com.magna.confeccao.domain.modelagem.Modelagem;
import br.com.magna.confeccao.domain.modelagem.Prega;
import br.com.magna.confeccao.domain.modelagem.Silhueta;
import br.com.magna.confeccao.domain.roupa.Roupa;
import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.repository.BarraRepository;
import br.com.magna.confeccao.repository.FechamentoRepository;
import br.com.magna.confeccao.repository.PregaRepository;
import br.com.magna.confeccao.repository.RoupaRepository;
import br.com.magna.confeccao.repository.SilhuetaRepository;
import jakarta.validation.Valid;

@Service
public class ModelagemService {

	@Autowired
	private FechamentoRepository fechamentoRepository;
	@Autowired
	private BarraRepository barraRepository;
	@Autowired
	private SilhuetaRepository silhuetaRepository;
	@Autowired
	private PregaRepository pregaRepository;
	@Autowired
	private RoupaRepository roupaRepository;

	public Modelagem criarModelagem(@Valid DadosCadastroModelagemDTO dados) {
		Modelagem modelagem = new Modelagem();
		modelagem.setSilhueta(verificaEPegaSilhueta(dados.idSilhueta()));
		modelagem.setFechamento(verificaEPegaFechamento(dados.idFechamento()));
		modelagem.setCinto(dados.cinto());
		modelagem.setPassantes(dados.passantes());
		modelagem.setPences(dados.pences());
		modelagem.setPala(dados.pala());
		modelagem.setPrega(verificaEPegaPrega(dados.idPrega()));
		modelagem.setBabado(dados.babado());
		modelagem.setFenda(dados.fenda());
		modelagem.setBolsos(dados.bolsos());
		modelagem.setForro(dados.forro());
		modelagem.setBarra(verificaEPegaBarra(dados.idBarra()));

		return modelagem;

	}

	public Modelagem atualizaModelagem(Long idRoupa, @Valid DadosCadastroModelagemDTO dados) {
		Roupa roupa = roupaRepository.getReferenceById(idRoupa);
		Modelagem modelagem = roupa.getModelagem();

		modelagem.setSilhueta(verificaEPegaSilhueta(dados.idSilhueta()));
		modelagem.setFechamento(verificaEPegaFechamento(dados.idFechamento()));
		modelagem.setPrega(verificaEPegaPrega(dados.idPrega()));
		modelagem.setBarra(verificaEPegaBarra(dados.idBarra()));
		modelagem.setCinto(dados.cinto());
		modelagem.setPassantes(dados.passantes());
		modelagem.setPences(dados.pences());
		modelagem.setPala(dados.pala());
		modelagem.setBabado(dados.babado());
		modelagem.setFenda(dados.fenda());
		modelagem.setBolsos(dados.bolsos());
		modelagem.setForro(dados.forro());

		return modelagem;
	}

	private Silhueta verificaEPegaSilhueta(Long idSilhueta) {
		if (!silhuetaRepository.existsById(idSilhueta)) {
			throw new ValidacaoException("Id de Silhueta informado não existe");
		}

		return silhuetaRepository.getReferenceById(idSilhueta);
	}

	private Fechamento verificaEPegaFechamento(Long idFechamento) {
		if (!fechamentoRepository.existsById(idFechamento)) {
			throw new ValidacaoException("Id de Fechamento informado não existe");
		}

		return fechamentoRepository.getReferenceById(idFechamento);
	}

	private Barra verificaEPegaBarra(Long idBarra) {
		if (!barraRepository.existsById(idBarra)) {
			throw new ValidacaoException("Id de Barra informado não existe");
		}
		return barraRepository.getReferenceById(idBarra);
	}

	private Prega verificaEPegaPrega(Long idPrega) {
		if (!pregaRepository.existsById(idPrega)) {
			throw new ValidacaoException("Id de tipo Prega informado não existe");
		}

		return pregaRepository.getReferenceById(idPrega);
	}
}
