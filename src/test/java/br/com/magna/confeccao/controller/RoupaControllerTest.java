
package br.com.magna.confeccao.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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

	private DadosCadastroRoupaDTO criaRoupaCadastro() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO();
		modelagem.setIdSilhueta(1L);
		modelagem.setIdFechamento(1L);
		modelagem.setCinto(true);
		modelagem.setPassantes(true);
		modelagem.setPences(true);
		modelagem.setPala(true);
		modelagem.setIdPrega(1L);
		modelagem.setBabado(true);
		modelagem.setFenda(true);
		modelagem.setBolsos(2);
		modelagem.setForro(true);
		modelagem.setIdBarra(1L);

		Long[] fibras = { 1l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO();
		tecido.setIdDasFibras(fibras);
		tecido.setConstrucao(ConstrucaoEnum.MALHA);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO();
		parteDeCima.setIdManga(1l);
		parteDeCima.setIdDecote(1l);
		parteDeCima.setIdCava(1l);
		parteDeCima.setCapuz(false);
		parteDeCima.setIdComprimento(1l);

		DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO();
		roupa.setNome("roupa-");
		roupa.setTipoRoupa("camiseta");
		roupa.setGenero(Genero.FEMININO);
		roupa.setCor("rosa");
		roupa.setTamanho(34);
		roupa.setTemEstampa(true);
		roupa.setTemBordado(false);
		roupa.setModelagem(modelagem);
		roupa.setTecido(tecido);
		roupa.setParteDeCima(parteDeCima);

		return roupa;
	}

	private DadosAtualizaRoupaDTO criaRoupaAtualizar() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO();
		modelagem.setIdSilhueta(1L);
		modelagem.setIdFechamento(1L);
		modelagem.setCinto(true);
		modelagem.setPassantes(true);
		modelagem.setPences(true);
		modelagem.setPala(true);
		modelagem.setIdPrega(1L);
		modelagem.setBabado(true);
		modelagem.setFenda(true);
		modelagem.setBolsos(2);
		modelagem.setForro(true);
		modelagem.setIdBarra(1L);

		Long[] fibras = { 1l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO();
		tecido.setIdDasFibras(fibras);
		tecido.setConstrucao(ConstrucaoEnum.MALHA);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO();
		parteDeCima.setIdManga(1l);
		parteDeCima.setIdDecote(1l);
		parteDeCima.setIdCava(1l);
		parteDeCima.setCapuz(false);
		parteDeCima.setIdComprimento(1l);

		DadosAtualizaRoupaDTO roupa = new DadosAtualizaRoupaDTO();
		roupa.setId(1l);
		roupa.setNome("mudei o nome eba");
		roupa.setTipoRoupa("camiseta");
		roupa.setGenero(Genero.FEMININO);
		roupa.setCor("rosa");
		roupa.setTamanho(34);
		roupa.setTemEstampa(true);
		roupa.setTemBordado(false);
		roupa.setModelagem(modelagem);
		roupa.setTecido(tecido);
		roupa.setParteDeCima(parteDeCima);

		return roupa;
	}

	

	@Test
	@DisplayName("Cadastro: deveria devolver codigo http 200 quando infos estao validas")
	void testCadastrarRoupaInfosValidas() {

		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		ResponseEntity<Roupa> response = restTemplate.postForEntity("/confeccao", roupa, Roupa.class);
		assertTrue(response.getStatusCode().isSameCodeAs(HttpStatus.CREATED));
		// assertTrue(response.getStatusCode().is2xxSuccessful());

	}

	@Test
	@DisplayName("Cadastro com Id Silhueta Null: deveria devolver codigo http 400 quando infos estao invalidas")
	void testCadastrarRoupaInfosInvalidasSilhuetaId() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setIdSilhueta(null);

		ResponseEntity<List> response = restTemplate.postForEntity("/confeccao", roupa, List.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}

	@Test
	@DisplayName("Cadastro com Exceção De Sem Fechamento e Construção Tecido Diferente de Malha: deveria devolver mensagem de ValidacaoConstrucaoTecidoEFechamento")
	void testCadastrarRoupaValidacaoFechamentoConstrucao() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setIdFechamento(13l);
		roupa.getTecido().setConstrucao(ConstrucaoEnum.PLANO);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha",
				response.getBody());

	}

	@Test
	@DisplayName("Cadastro com Exceção De Sem Fechamento e Construção Tecido Diferente de Malha Sem Silhueta Larga: deveria devolver mensagem de ValidacaoConstrucaoTecidoEFechamento")
	void testCadastrarRoupaValidacaoFechamentoSilhueta() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setIdFechamento(13l);
		roupa.getTecido().setConstrucao(ConstrucaoEnum.PLANO);
		roupa.getModelagem().setIdSilhueta(2l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha",
				response.getBody());

	}

	@Test
	@DisplayName("Cadastro com Exceção de Fibras com length igua a zero: deveria devolver mensagem de ValidacaoFibrasMaiorQueZero ")
	void testCadastrarRoupaValidacaoFibrasMaiorQueZero() {
		Long[] fibras = {};

		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getTecido().setIdDasFibras(fibras);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Necessário inserir pelo menos uma fibra na composição", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Fibra Inexistente: deveria devolver mensagem de ValidacaoFibrasExistem ")
	void testCadastrarRoupaValidacaoFibrasNaoExistem() {
		Long[] fibras = { 30l };

		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getTecido().setIdDasFibras(fibras);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de fibra inexistente", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Fibra Couro: deveria devolver mensagem de ValidacaoFibraCouroEhUnica ")
	void testCadastrarRoupaValidacaoFibraCouroEhSozinha() {
		Long[] fibras = { 1l, 2l, 3l };

		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getTecido().setIdDasFibras(fibras);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Couro não é uma fibra que possa ser misturada", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Decote Tomara que caia Com Cava: deveria devolver mensagem de ValidacaoTomaraQueCaiaNaoTemCava ")
	void testCadastrarRoupaValidacaoTomaraQueCaiaComCava() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setIdDecote(3l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Peças tomara-que-caia não possuem cava", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Decote Colarinho com Capuz: deveria devolver mensagem de ValidacaoCapuzNaoTemColarinhoNemLapela ")
	void testCadastrarRoupaValidacaoCapuzSemColarinho() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setCapuz(true);
		roupa.getParteDeCima().setIdDecote(9l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Peças com Colarinho ou Lapela não possuem capuz", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Tipo De Roupa Inexistente: deveria devolver mensagem de ValidacaoTipoRoupaExiste ")
	void testCadastrarRoupaValidacaoTipoDeRoupaInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.setTipoRoupa("colar");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de TipoRoupa informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Manga Inexistente: deveria devolver mensagem de ValidacaoMangaExiste ")
	void testCadastrarRoupaValidacaoMangaInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setIdManga(34l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Manga informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Decote Inexistente: deveria devolver mensagem de ValidacaoDecoteExiste ")
	void testCadastrarRoupaValidacaoDecoteInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setIdDecote(54l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		// assertEquals("Id de Decote informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Cava Inexistente: deveria devolver mensagem de ValidacaoCavaExiste ")
	void testCadastrarRoupaValidacaoCavaInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setIdCava(34l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Cava informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Comprimento Inexistente: deveria devolver mensagem de ValidacaoComprimentoExiste ")
	void testCadastrarRoupaValidacaoComprimentoInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setIdComprimento(34l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Comprimento informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Silhueta Inexistente: deveria devolver mensagem de ValidacaoSilhuetaExiste ")
	void testCadastrarRoupaValidacaoSilhuetaInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setIdSilhueta(100l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Silhueta informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Fechamento Inexistente: deveria devolver mensagem de ValidacaoFechamentoExiste ")
	void testCadastrarRoupaValidacaoFechamentoInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setIdFechamento(100l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		// assertEquals("Id de Fechamento informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Barra Inexistente: deveria devolver mensagem de ValidacaoBarraExiste ")
	void testCadastrarRoupaValidacaoBarraInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setIdBarra(100l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Barra informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Prega Inexistente: deveria devolver mensagem de ValidacaoPregaExiste ")
	void testCadastrarRoupaValidacaoPregaInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setIdPrega(100l);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Prega informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}


	
	@Test
	@DisplayName("Listagem: deveria devolver codigo http 200 quando infos estao validas")
	void testListarRoupa() {

		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/listagem", Roupa.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());

	}

	
	
	@Test
	@DisplayName("Atualizar: deveria devolver codigo http 200 quando infos estao validas")
	void testAtualizarRoupaInfosValidas() {
		DadosAtualizaRoupaDTO roupa = criaRoupaAtualizar();

		ResponseEntity<DadosDetalhamentoRoupaDTO> response = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupa), DadosDetalhamentoRoupaDTO.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertEquals(1l, response.getBody().modelagem().getSilhueta().getId());
	}

	
	
	@Test
	@DisplayName("Detalhar: deveria devolver codigo http 200 quando infos estao validas")
	void testDetalharRoupaPorIdValido() {

		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/listagem/1", Roupa.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertEquals(1l, response.getBody().getId());

	}


	@Test
	@DisplayName("Deletar: deveria devolver codigo http 204 quando infos estao validas")
	void testDeletarRoupaValida() {

		restTemplate.delete("/confeccao/1");
		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/1", Roupa.class);
		assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());

	}

	@Test
	@DisplayName("Deletar: deveria devolver codigo http 400 quando infos estao invalidas")
	void testDeletarRoupaInvalido() throws Exception {

		restTemplate.delete("/confeccao/100");
		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/100", Roupa.class);

		assertTrue(response.getStatusCode().is4xxClientError());

	}

}
