package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.ComprimentoParteCimaDomain;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.repository.ComprimentoDomainRepository;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;

@Component
public class ValidacaoComprimentoJaquetaColeteBlazer implements ValidadorRoupaCadastro{
	
	@Autowired
	private ComprimentoDomainRepository comprimentoRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validar(DadosCadastroRoupaDTO dados) {
		ComprimentoParteCimaDomain comprimento = comprimentoRepository.getReferenceById(dados.getParteDeCima().getIdComprimento());
		TipoRoupaDomain tipo = tipoRoupaDomainRepository.getReferenceById(dados.getTipoRoupa());
		
		
		if((tipo.getTipoRoupa().equals("colete") 
				|| tipo.getTipoRoupa().equals("blazer")
				|| tipo.getTipoRoupa().equals("jaqueta")
				)
				&& !(comprimento.getDescricao().contains("cropped")
						||comprimento.getDescricao().contains("cintura")
						|| comprimento.getDescricao().contains("torax")
						|| comprimento.getDescricao().contains("abaixo do quadril")
						|| comprimento.getDescricao().contains("quadril")
						)
			) {
			throw new ValidacaoException("Colete, Blazer e Jaqueta possuem comprimento acima do meio da coxa");
		}
		
		
	}
	


	
}
