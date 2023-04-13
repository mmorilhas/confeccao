package br.com.magna.confeccao.entities.roupa.validacoes.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.MangaDomain;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.repository.MangaDomainRepository;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;

@Component
public class ValidacaoPonchoNaoTemManga implements ValidadorRoupaCadastro, ValidadorRoupaAtualizar{
	
	@Autowired
	private MangaDomainRepository mangaRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validarCadastro(DadosCadastroRoupaDTO dados) {
		MangaDomain manga = mangaRepository.getReferenceById(dados.getParteDeCima().getIdManga());
		TipoRoupaDomain tipo = tipoRoupaDomainRepository.getReferenceById(dados.getTipoRoupa());
		
		
		if( tipo.getTipoRoupa().equals("poncho") 
				&& ! manga.getComprimento().contains("sem")){
				throw new ValidacaoException("Ponchos não possuem mangas");
		}
			
		
	}

	@Override
	public void validarAtualiza(DadosAtualizaRoupaDTO dados) {
		MangaDomain manga = mangaRepository.getReferenceById(dados.getParteDeCima().getIdManga());
		TipoRoupaDomain tipo = tipoRoupaDomainRepository.getReferenceById(dados.getTipoRoupa());
		
		
		if( tipo.getTipoRoupa().equals("poncho") 
				&& ! manga.getComprimento().contains("sem")){
				throw new ValidacaoException("Ponchos não possuem mangas");
		}
		
	}
	


	
}
