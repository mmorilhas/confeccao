package br.com.magna.confeccao.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
import org.springframework.web.bind.MethodArgumentNotValidException;

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
	void testListarRoupa() {
		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao", Roupa.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());

	}

	@Test
	@DisplayName("Cadastro: deveria devolver codigo http 200 quando infos estao validas")
	void testCadastrarRoupa() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(1L, 1l, false, false, true, false, 1l,
				false, false, 2, true, 1l);
		Long[] fibras = { 1l, 2l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, Construcao.PLANO);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);

		DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO("camisa", 34, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);

		ResponseEntity<Roupa> response = restTemplate.postForEntity("/confeccao", roupa, Roupa.class);

		assertTrue(response.getStatusCode().isSameCodeAs(HttpStatus.CREATED));
	}

	
	@Test
	@DisplayName("Cadastro: deveria devolver codigo http 400 quando infos estao invalidas")
	void testCadastrarRoupa2() throws Exception {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(null, 1l, false, false, true, false, 1l,
				false, false, 2, true, 1l);
		Long[] fibras = { 1l, 2l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, Construcao.PLANO);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);

		DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO("camisa", 34, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);

	
		ResponseEntity<List> response = restTemplate.postForEntity("/confeccao", roupa, List.class);
		

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertTrue(response.getStatusCode().is4xxClientError());
		
		
	}

	@Test
	@DisplayName("Atualizar: deveria devolver codigo http 200 quando infos estao validas")
	void testAtualizarRoupa() {
		DadosAtualizaModelagemDTO modelagem = new DadosAtualizaModelagemDTO(2L, 2l, false, false, true, false, 1l,
				false, false, 2, true, 1l);
		Long[] fibras = { 1l, 2l, 3l };
		DadosAtualizaTecidoDTO tecido = new DadosAtualizaTecidoDTO(2l, fibras, Construcao.MALHA);

		DadosAtualizaParteDeCimaDTO parteDeCima = new DadosAtualizaParteDeCimaDTO(2l, 2l, 2l, false, 2l);

		DadosAtualizaRoupaDTO roupa = new DadosAtualizaRoupaDTO(2l, "camisa", 34, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);

		ResponseEntity<DadosDetalhamentoRoupaDTO> response = restTemplate.exchange("/confeccao", HttpMethod.PUT,
				new HttpEntity<>(roupa), DadosDetalhamentoRoupaDTO.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertEquals(2l,response.getBody().modelagem().getSilhueta().getId());
	}

	@Test
	@DisplayName("Atualizar: deveria devolver codigo http 500 quando infos estao invalidas")
	void testAtualizarRoupa2() throws Exception {
		DadosAtualizaRoupaDTO roupa = criaDadosAtualizaRoupaDTOComModelagemIdSilhuetaInvalido();

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.PUT,
				new HttpEntity<>(roupa), String.class);

		assertTrue(response.getStatusCode().is4xxClientError());

	}

	

	@Test
	@DisplayName("Detalhar: deveria devolver codigo http 200 quando infos estao validas")
	void testPegarRoupaPorId() {

		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/1", Roupa.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertEquals(1l,response.getBody().getId());

	}

	@Test
	@DisplayName("Detalhar: deveria devolver codigo http 500 quando infos estao invalidas")
	void testPegarRoupaPorId2() throws Exception {

		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/300", Roupa.class);

		assertTrue(response.getStatusCode().is4xxClientError());

	}

	@Test
	@DisplayName("Deletar: deveria devolver codigo http 200 quando infos estao validas")
	void testDeletarRoupa() {

		restTemplate.delete("/confeccao/10");
		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/1", Roupa.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());

	}

	@Test
	@DisplayName("Deletar: deveria devolver codigo http 500 quando infos estao invalidas")
	void testDeletarRoupa2() throws Exception {

		restTemplate.delete("/confeccao/10");
		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/100", Roupa.class);

		assertTrue(response.getStatusCode().is4xxClientError());

	}
	
	private DadosAtualizaRoupaDTO criaDadosAtualizaRoupaDTOComModelagemIdSilhuetaInvalido() {
		DadosAtualizaModelagemDTO modelagem = new DadosAtualizaModelagemDTO(20l, 2l, false, false, true, false, 1l,
				false, false, 2, true, 1l);
		Long[] fibras = { 1l, 2l, 3l };
		DadosAtualizaTecidoDTO tecido = new DadosAtualizaTecidoDTO(2l, fibras, Construcao.MALHA);

		DadosAtualizaParteDeCimaDTO parteDeCima = new DadosAtualizaParteDeCimaDTO(2l, 2l, 2l, false, 2l);

		DadosAtualizaRoupaDTO roupa = new DadosAtualizaRoupaDTO(2l, "camisa", 34, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);
		return roupa;
		
	}

}
