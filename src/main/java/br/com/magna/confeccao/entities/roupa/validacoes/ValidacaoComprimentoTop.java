package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.ComprimentoParteCimaDomain;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.repository.ComprimentoRepository;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;

@Component
public class ValidacaoComprimentoTop implements ValidadorRoupaCadastro{
	
	@Autowired
	private ComprimentoRepository comprimentoRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validar(DadosCadastroRoupaDTO dados) {
		ComprimentoParteCimaDomain comprimento = comprimentoRepository.getReferenceById(dados.getParteDeCima().getIdComprimento());
		TipoRoupaDomain tipo = tipoRoupaDomainRepository.getReferenceById(dados.getTipoRoupa());
		
		
		if(tipo.getTipoRoupa().equals("top") 
				&& !(comprimento.getDescricao().contains("cropped")
						|| comprimento.getDescricao().contains("cintura")
						|| comprimento.getDescricao().contains("torax")
						)
			) {
			throw new ValidacaoException("Top possui comprimento na cintura ou acima");
		}
		
	}
	


	
}
