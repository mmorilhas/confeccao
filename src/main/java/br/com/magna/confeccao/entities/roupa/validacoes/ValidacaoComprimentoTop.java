package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.ComprimentoDomain;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.repository.domain.ComprimentoDomainRepository;
import br.com.magna.confeccao.repository.domain.TipoRoupaDomainRepository;

@Component
public class ValidacaoComprimentoTop implements ValidadorRoupaCadastro, ValidadorRoupaAtualizar{
	
	@Autowired
	private ComprimentoDomainRepository comprimentoRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		String comprimento = comprimentoRepository.findyByComprimento(dados.getParteDeCima().getComprimento());
		String tipo = tipoRoupaDomainRepository.findByTipoRoupa(dados.getTipoRoupa());
		
		
		if(tipo.equals("top") 
				&& !(comprimento.contains("cropped")
						|| comprimento.contains("cintura")
						|| comprimento.contains("torax")
						)
			) {
			throw new ValidacaoException("Top possui comprimento na cintura ou acima");
		}
		
	}

	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
		String comprimento = comprimentoRepository.findyByComprimento(dados.getParteDeCima().getComprimento());
		String tipo = tipoRoupaDomainRepository.findByTipoRoupa(dados.getTipoRoupa());
		
		
		if(tipo.equals("top") 
				&& !(comprimento.contains("cropped")
						|| comprimento.contains("cintura")
						|| comprimento.contains("torax")
						)
			) {
			throw new ValidacaoException("Top possui comprimento na cintura ou acima");
		}
		
	}
	


	
}
