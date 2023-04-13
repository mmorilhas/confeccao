package br.com.magna.confeccao.entities.roupa.validacoes.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.modelagem.FechamentoDomain;
import br.com.magna.confeccao.entities.domain.modelagem.SilhuetaDomain;
import br.com.magna.confeccao.entities.tecido.ConstrucaoEnum;
import br.com.magna.confeccao.repository.FechamentoDomainRepository;
import br.com.magna.confeccao.repository.SilhuetaDomainRepository;

@Component
public class ValidacaoCadastroConstrucaoTecidoEFechamento implements ValidadorRoupaCadastro, ValidadorRoupaAtualizar{

	@Autowired
	private FechamentoDomainRepository fechamentoRepository;

	@Autowired
	private SilhuetaDomainRepository silhuetaRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		FechamentoDomain fechamento = fechamentoRepository.getReferenceById(dados.getModelagem().getIdFechamento());
		SilhuetaDomain silhueta = silhuetaRepository.getReferenceById(dados.getModelagem().getIdSilhueta());
		if ((fechamento.getLocal().equalsIgnoreCase("sem") && !(dados.getTecido().getConstrucao().equals(ConstrucaoEnum.MALHA)
				|| silhueta.getDescricao().equalsIgnoreCase("larga"))) ) {
				  throw new ValidacaoException(
							"Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha");
			
				  
		  }
		 
		
	}

	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
		FechamentoDomain fechamento = fechamentoRepository.getReferenceById(dados.getModelagem().getIdFechamento());
		SilhuetaDomain silhueta = silhuetaRepository.getReferenceById(dados.getModelagem().getIdSilhueta());
		if ((fechamento.getLocal().equalsIgnoreCase("sem") && !(dados.getTecido().getConstrucao().equals(ConstrucaoEnum.MALHA)
				|| silhueta.getDescricao().equalsIgnoreCase("larga"))) ) {
				  throw new ValidacaoException(
							"Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha");
			
				  
		  }
		
	}

}
