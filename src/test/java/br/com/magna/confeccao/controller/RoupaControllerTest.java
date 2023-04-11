package br.com.magna.confeccao.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import br.com.magna.confeccao.dto.DadosAtualizaRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroModelagemDTO;
import br.com.magna.confeccao.dto.DadosCadastroParteDeCimaDTO;
import br.com.magna.confeccao.dto.DadosCadastroRoupaDTO;
import br.com.magna.confeccao.dto.DadosCadastroTecidoDTO;
import br.com.magna.confeccao.dto.DadosDetalhamentoRoupaDTO;
import br.com.magna.confeccao.entities.roupa.Roupa;
import br.com.magna.confeccao.entities.roupa.enums.Genero;
import br.com.magna.confeccao.entities.tecido.ConstrucaoEnum;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoupaControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("Listagem: deveria devolver codigo http 200 quando infos estao validas")
	void testListarRoupa() {
		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/listagem", Roupa.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());

	}

	// CADASTRO -----------------------------------------------
	@Test
	@DisplayName("Cadastro: deveria devolver codigo http 200 quando infos estao validas")
	void testCadastrarRoupaInfosValidas() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(1l, 1l, true, true, true, true, 1l, true,
				true, 2, true, 1l);
		Long[] fibras = { 1l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, ConstrucaoEnum.MALHA);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);

		DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO("camisa", "jaqueta",34, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);

		ResponseEntity<Roupa> response = restTemplate.postForEntity("/confeccao", roupa, Roupa.class);
		assertTrue(response.getStatusCode().isSameCodeAs(HttpStatus.CREATED));
		//assertTrue(response.getStatusCode().is2xxSuccessful());

		
	}

	@Test
	@DisplayName("Cadastro com Tamanho Null: deveria devolver codigo http 400 quando infos estao invalidas")
	void testCadastrarRoupaInfosInvalidasTamanhoNull() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(1l, 1l, true, true, true, true, 1l, true,
				true, 2, true, 1l);
		Long[] fibras = { 1l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, ConstrucaoEnum.MALHA);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);

		DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO("camisa","jaqueta", null, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);

		ResponseEntity<List> response = restTemplate.postForEntity("/confeccao", roupa, List.class);

		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Id Silhueta Null: deveria devolver codigo http 400 quando infos estao invalidas")
	void testCadastrarRoupaInfosInvalidasSilhuetaId() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(null, 1l, false, false, true, false, 1l,
				false, false, 2, true, 1l);
		Long[] fibras = { 1l, 2l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, ConstrucaoEnum.PLANO);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);

		DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO("camisa","jaqueta", 34, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);

		ResponseEntity<List> response = restTemplate.postForEntity("/confeccao", roupa, List.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}

	@Test
	@DisplayName("Cadastro com Exceção De Sem Fechamento e Construção Tecido Diferente de Malha: deveria devolver mensagem de ValidacaoConstrucaoTecidoEFechamento")
	void testCadastrarRoupaValidacaoFechamentoConstrucao() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(1l, 13l, false, false, true, false, 1l,
				false, false, 2, true, 1l);
		Long[] fibras = { 1l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, ConstrucaoEnum.PLANO);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);

		DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO("camisa", "jaqueta",34, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha",
				response.getBody());

	}

	@Test
	@DisplayName("Cadastro com Exceção de Sem Fechamento e Construção Tecido Diferente de Malha: deveria devolver mensagem de ValidacaoConstrucaoTecidoEFechamento")
	void testCadastrarRoupaValidacaoFechamentoSilhueta() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(1l, 13l, false, false, true, false, 1l,
				false, false, 2, true, 1l);
		Long[] fibras = { 1l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, ConstrucaoEnum.MALHA);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);

		DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO("camisa","jaqueta" ,34, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha",
				response.getBody());

	}

	@Test
	@DisplayName("Cadastro com Exceção de Fibras com length igua a zero: deveria devolver mensagem de ValidacaoFibrasMaiorQueZero ")
	void testCadastrarRoupaValidacaoFibrasMaiorQueZero() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(1l, 1l, true, true, true, true, 1l, true,
				true, 2, true, 1l);
		Long[] fibras = {};
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, ConstrucaoEnum.MALHA);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 3l, 3l, false, 1l);

		DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO("camisa","jaqueta" ,34, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Necessário inserir pelo menos uma fibra na composição", response.getBody());

		assertTrue(response.getStatusCode().is4xxClientError());
	}

	// ATUALIZAR -----------------------------------------------
	@Test
	@DisplayName("Atualizar: deveria devolver codigo http 200 quando infos estao validas")
	void testAtualizarRoupaInfosValidas() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(1l, 1l, true, true, true, true, 1l, true,
				true, 2, true, 1l);
		Long[] fibras = { 1l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, ConstrucaoEnum.MALHA);
		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);
		DadosAtualizaRoupaDTO roupa = new DadosAtualizaRoupaDTO(1L, "camisa", "jaqueta",34, Genero.FEMININO, "rosa", true, true,
				modelagem, tecido, parteDeCima);

		ResponseEntity<DadosDetalhamentoRoupaDTO> response = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupa), DadosDetalhamentoRoupaDTO.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertEquals(1l, response.getBody().modelagem().getSilhueta().getId());
	}

	@Test
	@DisplayName("Atualizar: deveria devolver codigo http 500 quando infos estao invalidas")
	void testAtualizarRoupaInfosInvalidas() throws Exception {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO(20l, 1l, true, true, true, true, 1l, true,
				true, 2, true, 1l);
		Long[] fibras = { 1l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO(fibras, ConstrucaoEnum.MALHA);
		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO(1l, 1l, 1l, false, 1l);
		DadosAtualizaRoupaDTO roupa = new DadosAtualizaRoupaDTO(1l, "alterei o nome","jaqueta", 34, Genero.FEMININO, "rosa", true,
				true, modelagem, tecido, parteDeCima);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.PUT, new HttpEntity<>(roupa),
				String.class);

		assertTrue(response.getStatusCode().is4xxClientError());

	}

	// DETALHAR -----------------------------------------------
	@Test
	@DisplayName("Detalhar: deveria devolver codigo http 200 quando infos estao validas")
	void testDetalharRoupaPorIdValido() {

		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/listagem/1", Roupa.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertEquals(1l, response.getBody().getId());

	}

	@Test
	@DisplayName("Detalhar: deveria devolver codigo http 500 quando infos estao invalidas")
	void testDetalharRoupaPorIdInvalido() throws Exception {

		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/300", Roupa.class);
		assertTrue(response.getStatusCode().is4xxClientError());

	}

	// DELETAR -----------------------------------------------
	@Test
	@DisplayName("Deletar: deveria devolver codigo http 204 quando infos estao validas")
	void testDeletarRoupaValida() {

		restTemplate.delete("/confeccao/1");
		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/1", Roupa.class);
		assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());

	}

	@Test
	@DisplayName("Deletar: deveria devolver codigo http 500 quando infos estao invalidas")
	void testDeletarRoupaInvalido() throws Exception {

		restTemplate.delete("/confeccao/100");
		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/100", Roupa.class);

		assertTrue(response.getStatusCode().is4xxClientError());

	}

}
