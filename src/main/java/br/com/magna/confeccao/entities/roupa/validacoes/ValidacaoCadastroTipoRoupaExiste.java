package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;

@Component
public class ValidacaoCadastroTipoRoupaExiste implements ValidadorRoupaCadastro {

	@Autowired
	private TipoRoupaDomainRepository tipoRoupaRepository;

	@Override
	public void validar(DadosCadastroRoupaDTO dados) {
		if (!tipoRoupaRepository.existsById(dados.getTipoRoupa())) {
			throw new ValidacaoException("Id de TipoRoupa informado não existe");
		}
	}


}
