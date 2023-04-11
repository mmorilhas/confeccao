package br.com.magna.confeccao.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magna.confeccao.dto.DadosCadastroTecidoDTO;
import br.com.magna.confeccao.entities.domain.fibra.FibraDomain;
import br.com.magna.confeccao.entities.tecido.Tecido;
import br.com.magna.confeccao.entities.tecido.validacoes.ValidadorTecido;
import br.com.magna.confeccao.repository.FibraRepository;
import br.com.magna.confeccao.repository.TecidoRepository;
import jakarta.validation.Valid;

@Service
public class TecidoService {
	@Autowired
	private FibraRepository fibraRepository;

	@Autowired
	TecidoRepository tecidoRepository;

	@Autowired
	private List<ValidadorTecido> validadores;

	private String moderada = "moderada";
	private String alta = "alta";
	private String baixa = "baixa";

	public Tecido criarTecido(@Valid DadosCadastroTecidoDTO dados) {

		validadores.forEach(v -> v.validar(dados));
		
		Collection<FibraDomain> composicao = criarComposicao(dados.idDasFibras());

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

	public Tecido atualizaTecido(Long idRoupa, @Valid DadosCadastroTecidoDTO dados) {
		
		validadores.forEach(v -> v.validar(dados));
		
		Tecido tecido = tecidoRepository.getReferenceById(idRoupa);

		Collection<FibraDomain> composicao = criarComposicao(dados.idDasFibras());
		tecido.setComposicao(composicao);
		tecido.setTipoDeTecido(calcularTipoTecido(composicao));
		tecido.setTempoSecagem(calcularTempoSecagem(composicao));
		tecido.setRespiravel(calcularEhRespiravel(composicao));
		tecido.setAbsorcaoAgua(calcularAbsorcaoAgua(composicao));
		tecido.setElasticidade(calcularElasticidade(composicao));
		tecido.setComportamentoTermico(calcularComportamentoTermico(composicao));
		tecido.setResistencia(calcularResistencia(composicao));

		tecido.setConstrucao(dados.construcao());

		tecidoRepository.save(tecido);

		return tecido;
	}

	private Collection<FibraDomain> criarComposicao(Long[] ids) {

		Collection<FibraDomain> composicao = new HashSet<>();

		for (Long dado : ids) {
			FibraDomain fibra = fibraRepository.getReferenceById(dado);
			composicao.add(fibra);

		}

		return composicao;
	}

	private String calcularTipoTecido(Collection<FibraDomain> composicao) {
		Collection<String> caracteristicas = new HashSet<>();

		String tipoTecido;
		String natural = "natural";

		for (FibraDomain fibra : composicao) {
			caracteristicas.add(fibra.getTipoFibra());
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

	private String calcularTempoSecagem(Collection<FibraDomain> composicao) {
		Collection<String> caracteristicas = new HashSet<>();
		String tempoSecagem;
		String rapido = "rapido";

		for (FibraDomain fibra : composicao) {
			caracteristicas.add(fibra.getTempoSecagem());
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

	private Boolean calcularEhRespiravel(Collection<FibraDomain> composicao) {
		Boolean respiravel;
		Integer trues = 0;
		Integer falses = 0;

		for (FibraDomain fibra : composicao) {
			if (Boolean.TRUE.equals(fibra.getRespiravel())) {
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

	private String calcularAbsorcaoAgua(Collection<FibraDomain> composicao) {
		Collection<String> caracteristicas = new HashSet<>();
		String absorcaoAgua;
		String hidrofobico = "hidrofobico";

		for (FibraDomain fibra : composicao) {
			caracteristicas.add(fibra.getAbsorcaoAgua());
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

	private String calcularElasticidade(Collection<FibraDomain> composicao) {
		Collection<String> caracteristicas = new HashSet<>();
		String elasticidade;

		for (FibraDomain fibra : composicao) {
			caracteristicas.add(fibra.getElasticidade());
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

	private String calcularComportamentoTermico(Collection<FibraDomain> composicao) {
		Collection<String> caracteristicas = new HashSet<>();
		String compTermico;

		String boaConservacaoCalor = "boa conservacao de calor";

		for (FibraDomain fibra : composicao) {
			caracteristicas.add(fibra.getComportamentoTermico());
		}

		if (caracteristicas.size() > 1) {
			compTermico = "regulacao de calor moderada";

		} else {
			if (caracteristicas.contains(boaConservacaoCalor)) {
				compTermico = boaConservacaoCalor;
			} else {
				compTermico = "boa regulacao de calor";
			}
		}

		return compTermico;
	}

	private String calcularResistencia(Collection<FibraDomain> composicao) {
		Collection<String> caracteristicas = new HashSet<>();
		String resistencia;

		for (FibraDomain fibra : composicao) {
			caracteristicas.add(fibra.getResistencia());
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
