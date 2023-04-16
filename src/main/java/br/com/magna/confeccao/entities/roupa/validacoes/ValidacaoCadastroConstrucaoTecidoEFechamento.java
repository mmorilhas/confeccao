package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.tecido.ConstrucaoEnum;
import br.com.magna.confeccao.repository.domain.FechamentoDomainRepository;
import br.com.magna.confeccao.repository.domain.SilhuetaDomainRepository;

@Component
public class ValidacaoCadastroConstrucaoTecidoEFechamento implements ValidadorRoupaCadastro, ValidadorRoupaAtualizar{

	@Autowired
	private FechamentoDomainRepository fechamentoRepository;

	@Autowired
	private SilhuetaDomainRepository silhuetaRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		String fechamento = fechamentoRepository.findyByFechamento(dados.getModelagem().getFechamento());
		String silhueta = silhuetaRepository.findyBySilhueta(dados.getModelagem().getSilhueta());
		if ((fechamento.equalsIgnoreCase("sem") && !(dados.getTecido().getConstrucao().equals(ConstrucaoEnum.MALHA)
				|| silhueta.equalsIgnoreCase("larga"))) ) {
				  throw new ValidacaoException(
							"Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha");
			
				  
		  }
		 
		
	}

	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
		String fechamento = fechamentoRepository.findyByFechamento(dados.getModelagem().getFechamento());
		String silhueta = silhuetaRepository.findyBySilhueta(dados.getModelagem().getSilhueta());
		if ((fechamento.equalsIgnoreCase("sem") && !(dados.getTecido().getConstrucao().equals(ConstrucaoEnum.MALHA)
				|| silhueta.equalsIgnoreCase("larga"))) ) {
				  throw new ValidacaoException(
							"Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha");
			
				  
		  }
		
	}

}
