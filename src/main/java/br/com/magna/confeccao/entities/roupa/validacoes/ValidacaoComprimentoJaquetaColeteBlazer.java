package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.repository.domain.ComprimentoDomainRepository;
import br.com.magna.confeccao.repository.domain.TipoRoupaDomainRepository;

@Component
public class ValidacaoComprimentoJaquetaColeteBlazer implements ValidadorRoupaCadastro, ValidadorRoupaAtualizar{
	
	@Autowired
	private ComprimentoDomainRepository comprimentoRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		String comprimento = comprimentoRepository.findyByComprimento(dados.getParteDeCima().getComprimento());
		String tipo = tipoRoupaDomainRepository.findByTipoRoupa(dados.getTipoRoupa());
		
		
		if((tipo.equals("colete") 
				|| tipo.equals("blazer")
				|| tipo.equals("jaqueta")
				)
				&& !(comprimento.contains("cropped")
						||comprimento.contains("cintura")
						|| comprimento.contains("torax")
						|| comprimento.contains("abaixo do quadril")
						|| comprimento.contains("quadril")
						)
			) {
			throw new ValidacaoException("Colete, Blazer e Jaqueta possuem comprimento acima do meio da coxa");
		}
		
		
	}

	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
		String comprimento = comprimentoRepository.findyByComprimento(dados.getParteDeCima().getComprimento());
		String tipo = tipoRoupaDomainRepository.findByTipoRoupa(dados.getTipoRoupa());
		
		
		if((tipo.equals("colete") 
				|| tipo.equals("blazer")
				|| tipo.equals("jaqueta")
				)
				&& !(comprimento.contains("cropped")
						||comprimento.contains("cintura")
						|| comprimento.contains("torax")
						|| comprimento.contains("abaixo do quadril")
						|| comprimento.contains("quadril")
						)
			) {
			throw new ValidacaoException("Colete, Blazer e Jaqueta possuem comprimento acima do meio da coxa");
		}
		
	}
	


	
}
