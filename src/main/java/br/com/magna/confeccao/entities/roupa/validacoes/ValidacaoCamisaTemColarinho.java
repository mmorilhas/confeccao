
  package br.com.magna.confeccao.entities.roupa.validacoes;
  
  import org.springframework.beans.factory.annotation.Autowired;
import
  org.springframework.stereotype.Component;

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import
  br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import
  br.com.magna.confeccao.repository.domain.DecoteDomainRepository;
import
  br.com.magna.confeccao.repository.domain.TipoRoupaDomainRepository;
  
  @Component public class ValidacaoCamisaTemColarinho implements
  ValidadorRoupaCadastro, ValidadorRoupaAtualizar{
  
  @Autowired private DecoteDomainRepository decoteRepository;
  
  @Autowired private TipoRoupaDomainRepository tipoRoupaDomainRepository;
  
  @Override public void validarCadastro(DadosCadastroRoupaDTO dados) { String
  decote = decoteRepository.findyByDecote(dados.getParteDeCima().getDecote());
  String tipo =
  tipoRoupaDomainRepository.findByTipoRoupa(dados.getTipoRoupa());
  
  
  if(tipo.equals("camisa") && !decote.contains("colarinho") ) { throw new
  ValidacaoException("Camisas possuem decote colarinho"); }
  
  }
  
  @Override public void validarAtualiza(DadosAtualizaRoupaDTO dados) { String
  decote = decoteRepository.findyByDecote(dados.getParteDeCima().getDecote());
  String tipo =
  tipoRoupaDomainRepository.findByTipoRoupa(dados.getTipoRoupa());
  
  
  if(tipo.equals("camisa") && !decote.contains("colarinho") ) { throw new
  ValidacaoException("Camisas possuem decote colarinho"); }
  
  }
  
  
  
  
  }
 