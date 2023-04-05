package br.com.magna.confeccao.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.domain.fibra.Fibra;
import br.com.magna.confeccao.domain.tecido.Tecido;
import br.com.magna.confeccao.dto.DadosAtualizaTecidoDTO;
import br.com.magna.confeccao.dto.DadosCadastroTecidoDTO;
import br.com.magna.confeccao.repository.FibraRepository;
import br.com.magna.confeccao.repository.TecidoRepository;
import jakarta.validation.Valid;

@Service
public class TecidoService {
	@Autowired
	private FibraRepository fibraRepository;

	@Autowired
	TecidoRepository tecidoRepository;
	private String moderada = "moderada";
	private String alta = "alta";
	private String baixa = "baixa";

	public Tecido criarTecido(@Valid DadosCadastroTecidoDTO dados) {
		Collection<Fibra> composicao = criarComposicao(dados.idDasFibras());
		
		Tecido tecido = new Tecido();
		tecido.setComposicao(composicao);
		tecido.setConstrucao(dados.construcao());
		tecido.setTipoDeTecido(calcularTipoTecido(composicao));
		tecido.setTempoSecagem(calcularTempoSecagem(composicao));
		tecido.setRespiravel(calcularEhRespiravel(composicao));
		tecido.setAbsorcaoAgua(calcularAbsorcaoAgua(composicao));
		tecido.setElasticidade(calcularElasticidade(composicao));
		tecido.setComportamentoTermico(calcularComportamentoTermico(composicao));
		tecido.setResistencia(calcularResistencia(composicao));
		
		return tecido;

	}

	public Tecido atualizaTecido(@Valid DadosAtualizaTecidoDTO dados) {
		Tecido tecido = tecidoRepository.getReferenceById(dados.id());
		
		if (dados.idDasFibras() != null) {
			Collection<Fibra> composicao = criarComposicao(dados.idDasFibras());
			tecido.setComposicao(composicao);
			tecido.setTipoDeTecido(calcularTipoTecido(composicao));
			tecido.setTempoSecagem(calcularTempoSecagem(composicao));
			tecido.setRespiravel(calcularEhRespiravel(composicao));
			tecido.setAbsorcaoAgua(calcularAbsorcaoAgua(composicao));
			tecido.setElasticidade(calcularElasticidade(composicao));
			tecido.setComportamentoTermico(calcularComportamentoTermico(composicao));
			tecido.setResistencia(calcularResistencia(composicao));

		}

		if (dados.construcao() != null) {
			tecido.setConstrucao(dados.construcao());
		}

		tecidoRepository.save(tecido);

		return tecido;
	}

	public Collection<Fibra> criarComposicao(Long[] ids) {
		if(ids.length == 0) {
			throw new ValidacaoException("Necessário inserir pelo menos uma fibra na composição");
		}
		
		Collection<Fibra> composicao = new HashSet<>();

		for (Long dado : ids) {
			if (fibraRepository.existsById(dado)) {
				Fibra fibra = fibraRepository.getReferenceById(dado);
				composicao.add(fibra);
			}

		}

		return composicao;
	}

	public String calcularTipoTecido(Collection<Fibra> composicao) {
		Collection<String> caracteristicas = new HashSet<>();

		String tipoTecido;
		String natural = "natural";

		for (Fibra fibra : composicao) {
			String dado = fibra.getTipoFibra();
			caracteristicas.add(dado);
		}

		if (caracteristicas.contains(natural)) {

			if (caracteristicas.size() > 1) {
				tipoTecido = "misto";
			} else {
				tipoTecido = natural;
			}

		} else {

			tipoTecido = "sintetico";
		}

		return tipoTecido;
	}

	public String calcularTempoSecagem(Collection<Fibra> composicao) {
		Collection<String> caracteristicas = new HashSet<>();
		String tempoSecagem;

		String rapido = "rapido";

		for (Fibra fibra : composicao) {
			String dado = fibra.getTempoSecagem();
			caracteristicas.add(dado);
		}

		if (caracteristicas.size() > 1) {
			tempoSecagem = "mediano";

		} else {
			if (caracteristicas.contains(rapido)) {
				tempoSecagem = rapido;
			} else {
				tempoSecagem = "lento";
			}
		}

		return tempoSecagem;
	}

	public Boolean calcularEhRespiravel(Collection<Fibra> composicao) {
		Boolean respiravel;
		Integer trues = 0;
		Integer falses = 0;

		for (Fibra fibra : composicao) {
			Boolean dado = fibra.getRespiravel();
			if (Boolean.TRUE.equals(dado)) {
				trues++;
			} else {
				falses++;
			}
		}

		if (trues >= falses) {
			respiravel = true;
		} else {
			respiravel = false;
		}

		return respiravel;

	}

	public String calcularAbsorcaoAgua(Collection<Fibra> composicao) {
		Collection<String> caracteristicas = new HashSet<>();
		String absorcaoAgua;

		String hidrofobico = "hidrofobico";

		for (Fibra fibra : composicao) {
			String dado = fibra.getAbsorcaoAgua();
			caracteristicas.add(dado);
		}

		if (caracteristicas.size() > 1) {
			absorcaoAgua = "absorve agua moderadamente";

		} else {
			if (caracteristicas.contains(hidrofobico)) {
				absorcaoAgua = hidrofobico;
			} else {
				absorcaoAgua = "hidrofilico";
			}
		}

		return absorcaoAgua;
	}

	public String calcularElasticidade(Collection<Fibra> composicao) {
		Collection<String> caracteristicas = new HashSet<>();
		String elasticidade;

		for (Fibra fibra : composicao) {
			String dado = fibra.getElasticidade();
			caracteristicas.add(dado);
		}

		if (caracteristicas.size() > 1) {
			elasticidade = moderada;

		} else {
			if (caracteristicas.contains(baixa)) {
				elasticidade = baixa;
			} else {
				elasticidade = alta;
			}
		}

		return elasticidade;
	}

	public String calcularComportamentoTermico(Collection<Fibra> composicao) {
		Collection<String> caracteristicas = new HashSet<>();
		String compTermico;

		String ct1 = "boa conservacao de calor";

		for (Fibra fibra : composicao) {
			String dado = fibra.getComportamentoTermico();
			caracteristicas.add(dado);
		}

		if (caracteristicas.size() > 1) {
			compTermico = "regulacao de calor moderada";

		} else {
			if (caracteristicas.contains(ct1)) {
				compTermico = "boa conservacao de calor";
			} else {
				compTermico = "boa regulacao de calor";
			}
		}

		return compTermico;
	}

	public String calcularResistencia(Collection<Fibra> composicao) {
		Collection<String> caracteristicas = new HashSet<>();
		String resistencia;

		for (Fibra fibra : composicao) {
			String dado = fibra.getResistencia();
			caracteristicas.add(dado);
		}

		if (caracteristicas.size() > 1) {
			if (caracteristicas.contains(baixa)) {
				resistencia = moderada;
			} else {
				resistencia = alta;
			}

		} else {
			if (caracteristicas.contains(baixa)) {
				resistencia = baixa;
			} else if (caracteristicas.contains(moderada)) {
				resistencia = moderada;
			} else {
				resistencia = alta;
			}
		}

		return resistencia;
	}
}
