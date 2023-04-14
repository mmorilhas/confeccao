package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.repository.domain.TipoRoupaDomainRepository;

@Component
public class ValidacaoCadastroTipoRoupaExiste implements ValidadorRoupaCadastro, ValidadorRoupaAtualizar {

	@Autowired
	private TipoRoupaDomainRepository tipoRoupaRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		if (Boolean.FALSE.equals(tipoRoupaRepository.existsByTipoRoupa(dados.getTipoRoupa()))) {
			throw new ValidacaoException("TipoRoupa informado não existe");
		}
	}

	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
		if (Boolean.FALSE.equals(tipoRoupaRepository.existsByTipoRoupa(dados.getTipoRoupa()))) {
			throw new ValidacaoException("TipoRoupa informado não existe");
		}
		
	}


}
