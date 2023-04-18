package br.com.magna.confeccao.entities.roupa.validacoes.modelagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.entities.roupa.validacoes.ValidacaoException;
import br.com.magna.confeccao.repository.domain.BarraDomainRepository;

@Component
public class ValidacaoBarraExiste implements ValidadorModelagem{
	
	@Autowired
	private BarraDomainRepository barraRepository;

	@Override
	public void validar(DadosCadastroModelagemDTO dados) {
		if (Boolean.FALSE.equals(barraRepository.existsByBarra(dados.getBarra()))) {
			throw new ValidacaoException("Barra informada não existe");
		}
		
	}


	
}
