package br.com.magna.confeccao.domain.tecido.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.domain.ValidacaoException;
import br.com.magna.confeccao.domain.fibra.Fibra;
import br.com.magna.confeccao.dto.DadosCadastroTecidoDTO;
import br.com.magna.confeccao.repository.FibraRepository;

@Component
public class ValidacaoFibraCouroEhUnica implements ValidadorTecido {
	@Autowired
	private FibraRepository fibraRepository;

	@Override
	public void validar(DadosCadastroTecidoDTO dados) {

		if(dados.idDasFibras().length > 1) {
			for (Long dado : dados.idDasFibras()) {
				Fibra fibra = fibraRepository.getReferenceById(dado);
				if (fibra.getNomeFibra().equalsIgnoreCase("Couro")) {
					throw new ValidacaoException("Couro não é uma fibra que possa ser misturada");

				}
			}	
		}

	}

}
