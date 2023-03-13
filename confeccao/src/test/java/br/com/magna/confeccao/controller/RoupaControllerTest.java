package br.com.magna.confeccao.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.confeccao.domain.roupa.Genero;
import br.com.magna.confeccao.domain.roupa.Roupa;
import br.com.magna.confeccao.domain.tecido.Construcao;
import br.com.magna.confeccao.dto.DadosAtualizaModelagemDTO;
import br.com.magna.confeccao.dto.DadosAtualizaParteDeCimaDTO;
import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosAtualizaTecidoDTO;
import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroTecidoDTO;
import br.com.magna.confeccao.dto.DadosDetalhamentoRoupaDTO;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoupaControllerTest {

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    public void testListarRoupa() {
	    	ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao", Roupa.class);
	    
	    	assertTrue(response.getStatusCode().is2xxSuccessful());
	    	
	    }
	    
	    @Test
	    @DisplayName("Cadastro: deveria devolver codigo http 200 quando infos estao validas")
	    public void testCadastrarRoupa() {
	    	DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(1L, 1l, false, false, true, false, 1l, false, false, 2, true, 1l);
	    	Long[] fibras = {1l, 2l, 3l};
	    	DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, Construcao.PLANO);
	    	
	    	DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);
	    	
	    	DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO("camisa", 34, Genero.FEMININO, "rosa", true, true, modelagem, tecido, parteDeCima);
	    	
	    	ResponseEntity<Roupa> response = restTemplate.postForEntity("/confeccao", roupa, Roupa.class);
	    
	    assertTrue(response.getStatusCode().isSameCodeAs(HttpStatus.CREATED));    
	    }
	    
	    @Test
	    @DisplayName("Cadastro: deveria devolver codigo http 500 quando infos estao invalidas")
	    public void testCadastrarRoupa2() throws Exception {
	    	DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(10L, 1l, false, false, true, false, 1l, false, false, 2, true, 1l);
	    	Long[] fibras = {1l, 2l, 3l};
	    	DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, Construcao.PLANO);
	    	
	    	DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);
	    	
	    	DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO("camisa", 34, Genero.FEMININO, "rosa", true, true, modelagem, tecido, parteDeCima);
	    	
	    	ResponseEntity<Roupa> response = restTemplate.postForEntity("/confeccao", roupa, Roupa.class);
	    
	    assertTrue(response.getStatusCode().is5xxServerError()
	    		//.isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)
	    		);    
	    }
	    

	    @Test
	    @DisplayName("Atualizar: deveria devolver codigo http 200 quando infos estao validas")
	    public void testAtualizarRoupa() {
	    	DadosAtualizaModelagemDTO modelagem = new DadosAtualizaModelagemDTO(2L, 2l, false, false, true, false, 1l, false, false, 2, true, 1l);
	    	Long[] fibras = {1l, 2l, 3l};
	    	DadosAtualizaTecidoDTO tecido = new DadosAtualizaTecidoDTO(2l, fibras, Construcao.MALHA);
	    	
	    	DadosAtualizaParteDeCimaDTO parteDeCima = new DadosAtualizaParteDeCimaDTO(2l, 2l, 2l, false);
	    	
	    	DadosAtualizaRoupaDTO roupa = new DadosAtualizaRoupaDTO(2l, "camisa", 34, Genero.FEMININO, "rosa", true, true, modelagem, tecido, parteDeCima);
	    	
	    	ResponseEntity<DadosDetalhamentoRoupaDTO> response = restTemplate.exchange("/confeccao", HttpMethod.PUT, new HttpEntity<>(roupa), DadosDetalhamentoRoupaDTO.class);
	    
	  assertTrue(response.getStatusCode().is2xxSuccessful());
	  assertTrue(response.getBody().modelagem().getSilhueta().getId().equals(2l));
	    }
	    
	    @Test
	    @DisplayName("Atualizar: deveria devolver codigo http 500 quando infos estao invalidas")
	    public void testAtualizarRoupa2() throws Exception{
	    	DadosAtualizaModelagemDTO modelagem = new DadosAtualizaModelagemDTO(20L, 2l, false, false, true, false, 1l, false, false, 2, true, 1l);
	    	Long[] fibras = {1l, 2l, 3l};
	    	DadosAtualizaTecidoDTO tecido = new DadosAtualizaTecidoDTO(2l, fibras, Construcao.MALHA);
	    	
	    	DadosAtualizaParteDeCimaDTO parteDeCima = new DadosAtualizaParteDeCimaDTO(2l, 2l, 2l, false);
	    	
	    	DadosAtualizaRoupaDTO roupa = new DadosAtualizaRoupaDTO(2l, "camisa", 34, Genero.FEMININO, "rosa", true, true, modelagem, tecido, parteDeCima);
	    	
	    	ResponseEntity<DadosDetalhamentoRoupaDTO> response = restTemplate.exchange("/confeccao", HttpMethod.PUT, new HttpEntity<>(roupa), DadosDetalhamentoRoupaDTO.class);
	    
	  assertTrue(response.getStatusCode().is5xxServerError());

	    }
	    
	    
	    @Test
	    @DisplayName("Detalhar: deveria devolver codigo http 200 quando infos estao validas")
	    public void testPegarRoupaPorId(){
	    
	    	
	    	ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/3", Roupa.class);
	    
	  assertTrue(response.getStatusCode().is2xxSuccessful());
	  assertTrue(response.getBody().getId().equals(3l));

	    }
	    
	    @Test
	    @DisplayName("Detalhar: deveria devolver codigo http 500 quando infos estao invalidas")
	    public void testPegarRoupaPorId2() throws Exception{
	    
	    	
	    	ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/300", Roupa.class);
	    
	  assertTrue(response.getStatusCode().is5xxServerError());

	    }
	    
	    @Test
	    @DisplayName("Deletar: deveria devolver codigo http 200 quando infos estao validas")
	    public void testDeletarRoupa(){
   	
	    	
	    	restTemplate.delete("/confeccao/10");
	        ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/10", Roupa.class);
	            
	  assertTrue(response.getStatusCode().is2xxSuccessful());

	    }
	    
	    @Test
	    @DisplayName("Deletar: deveria devolver codigo http 500 quando infos estao invalidas")
	    public void testDeletarRoupa2() throws Exception{
   	
	    	
	    	restTemplate.delete("/confeccao/10");
	        ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/100", Roupa.class);
	            
	  assertTrue(response.getStatusCode().is5xxServerError());

	    }

	    


}
