package br.com.magna.confeccao.domain.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.domain.modelagem.Fechamento;
import br.com.magna.confeccao.domain.modelagem.Silhueta;
import br.com.magna.confeccao.domain.tecido.Construcao;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.repository.FechamentoRepository;
import br.com.magna.confeccao.repository.SilhuetaRepository;

@Component
public class ValidacaoConstrucaoTecidoEFechamento implements ValidadorRoupa {

	@Autowired
	private FechamentoRepository fechamentoRepository;

	@Autowired
	private SilhuetaRepository silhuetaRepository;

	@Override
	public void validar(DadosCadastroRoupaDTO dados) {
		Fechamento fechamento = fechamentoRepository.getReferenceById(dados.modelagem().idFechamento());
		Silhueta silhueta = silhuetaRepository.getReferenceById(dados.modelagem().idSilhueta());

		if ((fechamento.getLocal().equalsIgnoreCase("sem") && !dados.tecido().construcao().equals(Construcao.MALHA))
				||  (fechamento.getLocal().equalsIgnoreCase("sem") && !silhueta.getDescricao().equalsIgnoreCase("larga"))) {
			throw new ValidacaoException(
					"Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha");

			
		}
			
		
	}

}
