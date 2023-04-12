package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.repository.DecoteDomainRepository;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;

@Component
public class ValidacaoCamisaTemColarinho implements ValidadorRoupaCadastro{
	
	@Autowired
	private DecoteDomainRepository decoteRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validar(DadosCadastroRoupaDTO dados) {
		DecoteDomain decote = decoteRepository.getReferenceById(dados.getParteDeCima().getIdDecote());
		TipoRoupaDomain tipo = tipoRoupaDomainRepository.getReferenceById(dados.getTipoRoupa());
		
		
		if(tipo.getTipoRoupa().equals("camisa") 
				&& !decote.getDescricao().contains("colarinho")
			) {
			throw new ValidacaoException("Camisas possuem decote colarinho");
		}
		
	}
	


	
}
