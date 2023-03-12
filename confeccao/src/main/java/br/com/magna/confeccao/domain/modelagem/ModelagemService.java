package br.com.magna.confeccao.domain.modelagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.domain.roupa.Roupa;
import br.com.magna.confeccao.domain.roupa.RoupaRepository;

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

	public Modelagem criarModelagem(DadosCadastroModelagem dados) {
		
		Modelagem modelagem = new Modelagem(
				verificaEPegaSilhueta(dados.idSilhueta()),
				verificaEPegaFechamento(dados.idFechamento()),
				dados.cinto(), 
				dados.passantes(),
				dados.pences(), 
				dados.pala(),
				verificaEPegaPrega(dados.idPrega()),
				dados.babado(), 
				dados.fenda(), 
				dados.bolsos(),
				dados.forro(), 
				verificaEPegaBarra(dados.idBarra())
				);

		return modelagem;

	}

	public Modelagem atualizaModelagem(Long idRoupa, DadosAtualizaModelagem dados) {
		Roupa roupa = roupaRepository.getReferenceById(idRoupa);
		Modelagem modelagem = roupa.getModelagem();

		if (dados.idSilhueta() != null) {
			modelagem.setSilhueta(verificaEPegaSilhueta(dados.idSilhueta()));
		}
		if (dados.idFechamento() != null) {
			modelagem.setFechamento(verificaEPegaFechamento(dados.idFechamento()));
		}
		if (dados.idPrega() != null) {
			modelagem.setPrega(verificaEPegaPrega(dados.idPrega()));
		}
		if (dados.idBarra() != null) {
			modelagem.setBarra(verificaEPegaBarra(dados.idBarra()));
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
		
		
		return modelagem;
	}

	private Silhueta verificaEPegaSilhueta(Long idSilhueta) {
		if (!silhuetaRepository.existsById(idSilhueta)) {
			throw new ValidacaoException("Id de Silhueta informado não existe");
		}

		Silhueta silhueta = silhuetaRepository.getReferenceById(idSilhueta);

		return silhueta;
	}

	private Fechamento verificaEPegaFechamento(Long idFechamento) {
		if (!fechamentoRepository.existsById(idFechamento)) {
			throw new ValidacaoException("Id de Fechamento informado não existe");
		}

		Fechamento fechamento = fechamentoRepository.getReferenceById(idFechamento);
		return fechamento;
	}

	private Barra verificaEPegaBarra(Long idBarra) {
		if (!barraRepository.existsById(idBarra)) {
			throw new ValidacaoException("Id de Barra informado não existe");
		}
		Barra barra = barraRepository.getReferenceById(idBarra);
		return barra;
	}

	private Prega verificaEPegaPrega(Long idPrega) {
		if (!pregaRepository.existsById(idPrega)) {
			throw new ValidacaoException("Id de tipo Prega informado não existe");
		}

		Prega prega = pregaRepository.getReferenceById(idPrega);
		return prega;
	}
}
