package br.com.magna.confeccao.entities.modelagem.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.repository.BarraRepository;

@Component
public class ValidacaoBarraExiste implements ValidadorModelagem{
	
	@Autowired
	private BarraRepository barraRepository;

	@Override
	public void validar(DadosCadastroModelagemDTO dados) {
		if (!barraRepository.existsById(dados.getIdBarra())) {
			throw new ValidacaoException("Id de Barra informado não existe");
		}
		
	}


	
}
