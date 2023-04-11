package br.com.magna.confeccao.entities.tecido.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroTecidoDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.fibra.FibraDomain;
import br.com.magna.confeccao.repository.FibraRepository;

@Component
public class ValidacaoFibraCouroEhUnica implements ValidadorTecido {
	@Autowired
	private FibraRepository fibraRepository;

	@Override
	public void validar(DadosCadastroTecidoDTO dados) {

		if(dados.idDasFibras().length > 1) {
			for (Long dado : dados.idDasFibras()) {
				FibraDomain fibra = fibraRepository.getReferenceById(dado);
				if (fibra.getNomeFibra().equalsIgnoreCase("Couro")) {
					throw new ValidacaoException("Couro não é uma fibra que possa ser misturada");

				}
			}	
		}

	}

}
