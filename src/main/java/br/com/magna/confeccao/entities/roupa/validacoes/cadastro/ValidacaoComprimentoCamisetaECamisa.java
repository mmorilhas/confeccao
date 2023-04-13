package br.com.magna.confeccao.entities.roupa.validacoes.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.ComprimentoParteCimaDomain;
import br.com.magna.confeccao.entities.domain.partecima.DecoteDomain;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.repository.ComprimentoDomainRepository;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;

@Component
public class ValidacaoComprimentoCamisetaECamisa implements ValidadorRoupaCadastro, ValidadorRoupaAtualizar{
	
	@Autowired
	private ComprimentoDomainRepository comprimentoRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		ComprimentoParteCimaDomain comprimento = comprimentoRepository.getReferenceById(dados.getParteDeCima().getIdComprimento());
		TipoRoupaDomain tipo = tipoRoupaDomainRepository.getReferenceById(dados.getTipoRoupa());
		
		
		if((tipo.getTipoRoupa().equals("camiseta") 
				|| tipo.getTipoRoupa().equals("camisa")
				|| tipo.getTipoRoupa().equals("blusa")
				)
				&& (comprimento.getDescricao().contains("joelho")
						|| comprimento.getDescricao().contains("abaixo do joelho")
						|| comprimento.getDescricao().contains("meio da canela")
						|| comprimento.getDescricao().contains("tornozelo")
						)
			) {
			throw new ValidacaoException("Camisas e Camisetas possuem comprimento acima do joelho");
		}
		
	}

	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
		ComprimentoParteCimaDomain comprimento = comprimentoRepository.getReferenceById(dados.getParteDeCima().getIdComprimento());
		TipoRoupaDomain tipo = tipoRoupaDomainRepository.getReferenceById(dados.getTipoRoupa());
		
		
		if((tipo.getTipoRoupa().equals("camiseta") 
				|| tipo.getTipoRoupa().equals("camisa")
				|| tipo.getTipoRoupa().equals("blusa")
				)
				&& (comprimento.getDescricao().contains("joelho")
						|| comprimento.getDescricao().contains("abaixo do joelho")
						|| comprimento.getDescricao().contains("meio da canela")
						|| comprimento.getDescricao().contains("tornozelo")
						)
			) {
			throw new ValidacaoException("Camisas e Camisetas possuem comprimento acima do joelho");
		}
		
	}
	
	
	


	
}
