package br.com.magna.confeccao.entities.roupa.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.entities.ValidacaoException;
import br.com.magna.confeccao.entities.domain.partecima.MangaDomain;
import br.com.magna.confeccao.entities.domain.roupa.TipoRoupaDomain;
import br.com.magna.confeccao.repository.MangaDomainRepository;
import br.com.magna.confeccao.repository.TipoRoupaDomainRepository;

@Component
public class ValidacaoPonchoNaoTemManga implements ValidadorRoupaCadastro{
	
	@Autowired
	private MangaDomainRepository mangaRepository;
	
	@Autowired
	private TipoRoupaDomainRepository tipoRoupaDomainRepository;

	@Override
	public void validar(DadosCadastroRoupaDTO dados) {
		MangaDomain manga = mangaRepository.getReferenceById(dados.getParteDeCima().getIdManga());
		TipoRoupaDomain tipo = tipoRoupaDomainRepository.getReferenceById(dados.getTipoRoupa());
		
		
		if( tipo.getTipoRoupa().equals("poncho") 
				&& ! manga.getComprimento().contains("sem")){
				throw new ValidacaoException("Ponchos não possuem mangas");
		}
			
		
	}
	


	
}
