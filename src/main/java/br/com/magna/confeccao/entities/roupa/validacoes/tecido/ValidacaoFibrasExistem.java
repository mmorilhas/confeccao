package br.com.magna.confeccao.entities.roupa.validacoes.tecido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroTecidoDTO;
import br.com.magna.confeccao.entities.roupa.validacoes.ValidacaoException;
import br.com.magna.confeccao.repository.domain.FibraDomainRepository;

@Component
public class ValidacaoFibrasExistem implements ValidadorTecido{

	@Autowired
	private FibraDomainRepository fibraRepository;
	
	@Override
	public void validar(DadosCadastroTecidoDTO dados) {
		
		for (Long id : dados.getIdDasFibras()) {
			if (! fibraRepository.existsById(id)) {
				throw new ValidacaoException("Id de fibra inexistente");

			}

		}
	}

}
