package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.repository.domain.MangaDomainRepository;
import br.com.magna.confeccao.repository.domain.TipoRoupaDomainRepository;

@Component
public class ValidacaoPonchoNaoTemManga implements ValidadorRoupaCadastro, ValidadorRoupaAtualizar{
	
	@Autowired
	private MangaDomainRepository mangaRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		String manga = mangaRepository.findyByManga(dados.getParteDeCima().getManga());
		String tipo = tipoRoupaDomainRepository.findByTipoRoupa(dados.getTipoRoupa());
		
		
		if( tipo.equals("poncho") 
				&& ! manga.contains("sem")){
				throw new ValidacaoException("Ponchos não possuem mangas");
		}
			
		
	}

	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
		String manga = mangaRepository.findyByManga(dados.getParteDeCima().getManga());
		String tipo = tipoRoupaDomainRepository.findByTipoRoupa(dados.getTipoRoupa());
		
		
		if( tipo.equals("poncho") 
				&& ! manga.contains("sem")){
				throw new ValidacaoException("Ponchos não possuem mangas");
		}
		
	}
	


	
}
