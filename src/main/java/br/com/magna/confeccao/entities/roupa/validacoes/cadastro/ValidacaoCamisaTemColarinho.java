package br.com.magna.confeccao.entities.roupa.validacoes.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.repository.DecoteDomainRepository;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;

@Component
public class ValidacaoCamisaTemColarinho implements ValidadorRoupaCadastro, ValidadorRoupaAtualizar{
	
	@Autowired
	private DecoteDomainRepository decoteRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		DecoteDomain decote = decoteRepository.getReferenceById(dados.getParteDeCima().getIdDecote());
		TipoRoupaDomain tipo = tipoRoupaDomainRepository.getReferenceById(dados.getTipoRoupa());
		
		
		if(tipo.getTipoRoupa().equals("camisa") 
				&& !decote.getDescricao().contains("colarinho")
			) {
			throw new ValidacaoException("Camisas possuem decote colarinho");
		}
		
	}

	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
		DecoteDomain decote = decoteRepository.getReferenceById(dados.getParteDeCima().getIdDecote());
		TipoRoupaDomain tipo = tipoRoupaDomainRepository.getReferenceById(dados.getTipoRoupa());
		
		
		if(tipo.getTipoRoupa().equals("camisa") 
				&& !decote.getDescricao().contains("colarinho")
			) {
			throw new ValidacaoException("Camisas possuem decote colarinho");
		}
		
	}
	


	
}
