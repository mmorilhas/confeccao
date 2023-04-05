package br.com.magna.confeccao.domain.tecido.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.domain.fibra.Fibra;
import br.com.magna.confeccao.dto.DadosCadastroTecidoDTO;
import br.com.magna.confeccao.repository.FibraRepository;

@Component
public class ValidacaoFibrasExistem implements ValidadorTecido{

	@Autowired
	private FibraRepository fibraRepository;
	
	@Override
	public void validar(DadosCadastroTecidoDTO dados) {
		
		for (Long dado : dados.idDasFibras()) {
			if (! fibraRepository.existsById(dado)) {
				throw new ValidacaoException("Id de fibra inexistente");

			}

		}
	}

}
