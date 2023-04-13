package br.com.magna.confeccao.entities.roupa.validacoes.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.ComprimentoParteCimaDomain;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.repository.ComprimentoDomainRepository;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;

@Component
public class ValidacaoComprimentoTop implements ValidadorRoupaCadastro, ValidadorRoupaAtualizar{
	
	@Autowired
	private ComprimentoDomainRepository comprimentoRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
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

	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
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
