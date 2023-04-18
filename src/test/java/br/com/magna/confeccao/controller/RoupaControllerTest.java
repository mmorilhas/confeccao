
package br.com.magna.confeccao.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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
		modelagem.setSilhueta("justa");
		modelagem.setFechamento("ziper lateral");
		modelagem.setCinto(true);
		modelagem.setPassantes(true);
		modelagem.setPences(true);
		modelagem.setPala(true);
		modelagem.setPrega("simples");
		modelagem.setBabado(true);
		modelagem.setFenda(true);
		modelagem.setBolsos(2);
		modelagem.setForro(true);
		modelagem.setBarra("simples");

		Long[] fibras = { 1l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO();
		tecido.setIdDasFibras(fibras);
		tecido.setConstrucao(ConstrucaoEnum.MALHA);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO();
		parteDeCima.setManga("regata raglan");
		parteDeCima.setDecote("canoa");
		parteDeCima.setCava("justa");
		parteDeCima.setCapuz(false);
		parteDeCima.setComprimento("quadril");

		DadosCadastroRoupaDTO roupa = new DadosCadastroRoupaDTO();
		roupa.setNome("roupa-");
		roupa.setColecao("colecao teste");
		roupa.setTipoRoupa("casaco");
		roupa.setGenero(Genero.FEMININO);
		roupa.setCor("rosa");
		roupa.setTamanhoInicial(34);
		roupa.setTamanhoFinal(44);
		roupa.setQuantidadePorTamanho(12);
		roupa.setTemEstampa(true);
		roupa.setTemBordado(false);
		roupa.setModelagem(modelagem);
		roupa.setTecido(tecido);
		roupa.setParteDeCima(parteDeCima);

		return roupa;
	}

	private DadosAtualizaRoupaDTO criaRoupaAtualizar() {
		DadosCadastroModelagemDTO modelagem = new DadosCadastroModelagemDTO();
		modelagem.setSilhueta("justa");
		modelagem.setFechamento("ziper frente");
		modelagem.setCinto(true);
		modelagem.setPassantes(true);
		modelagem.setPences(true);
		modelagem.setPala(true);
		modelagem.setPrega("plissado");
		modelagem.setBabado(true);
		modelagem.setFenda(true);
		modelagem.setBolsos(2);
		modelagem.setForro(true);
		modelagem.setBarra("simples");

		Long[] fibras = { 1l, 3l };
		DadosCadastroTecidoDTO tecido = new DadosCadastroTecidoDTO();
		tecido.setIdDasFibras(fibras);
		tecido.setConstrucao(ConstrucaoEnum.MALHA);

		DadosCadastroParteDeCimaDTO parteDeCima = new DadosCadastroParteDeCimaDTO();
		parteDeCima.setManga("regata raglan");
		parteDeCima.setDecote("canoa");
		parteDeCima.setCava("justa");
		parteDeCima.setCapuz(false);
		parteDeCima.setComprimento("quadril");

		DadosAtualizaRoupaDTO roupa = new DadosAtualizaRoupaDTO();
		roupa.setId(1l);
		roupa.setNome("mudei o nome eba");
		roupa.setColecao("colecao teste");
		roupa.setTipoRoupa("camiseta");
		roupa.setGenero(Genero.FEMININO);
		roupa.setCor("rosa");
		roupa.setTamanhoInicial(34);
		roupa.setTamanhoFinal(44);
		roupa.setQuantidadePorTamanho(12);
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
	}

	@Test
	@DisplayName("Cadastro com Id Silhueta Null: deveria devolver codigo http 400 quando infos estao invalidas")
	void testCadastrarRoupaInfosInvalidasSilhuetaNull() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setSilhueta(null);

		ResponseEntity<List> response = restTemplate.postForEntity("/confeccao", roupa, List.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

	}

	@Test
	@DisplayName("Cadastro com Exceção De Sem Fechamento e Construção Tecido Diferente de Malha: deveria devolver mensagem de ValidacaoConstrucaoTecidoEFechamento")
	void testCadastrarRoupaValidacaoFechamentoConstrucao() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setFechamento("sem");
		roupa.getTecido().setConstrucao(ConstrucaoEnum.PLANO);
		roupa.getModelagem().setSilhueta("justa");
		
		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha",
				response.getBody());

	}
	

	@ParameterizedTest(name= "{index} {0}: [fibras]={1}, [msgExcecao]={2}")
	@MethodSource("proveFibrasParaValidacaoComposicaoTecidoCadastro")
	@DisplayName("Cadastro: Validando Exceções de Fibras")
	void testCadastroRoupaValidacaoFibras(String nomeTeste, Long[] fibras, String msgExcecao) {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getTecido().setIdDasFibras(fibras);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals(msgExcecao, response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	private static Stream<Arguments> proveFibrasParaValidacaoComposicaoTecidoCadastro(){
		Long[] fibras = {};
		Long[] fibras1 = {30l};
		Long[] fibras2 = { 1l, 2l, 3l };
		return Stream.of(
				Arguments.of("Exceção de Fibras com length igua a zero" , fibras, "Necessário inserir pelo menos uma fibra na composição"),
				Arguments.of("Exceção de Fibras Inexistente" , fibras1, "Id de fibra inexistente"),
				Arguments.of("Exceção de Fibra Couro" , fibras2, "Couro não é uma fibra que possa ser misturada")
				);
	}

	
	@ParameterizedTest(name= "{index} {0}: [decote]={1}, [msgExcecao]={2}")
	@MethodSource("proveAtributosParaValidarExcecoesRoupasSemCapuz")
	@DisplayName("Cadastro: Excecao Tipo De Roupa: deveria devolver mensagem de ValidacaoException")
	void testCadastrarRoupaValidacaoExcecoesRoupasSemCapuz(String nomeTeste, String decote, String msgExcecao) {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setCapuz(true);
		roupa.getParteDeCima().setDecote(decote);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals(msgExcecao, response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	private static Stream<Arguments> proveAtributosParaValidarExcecoesRoupasSemCapuz(){
		return Stream.of(
				Arguments.of("Exceção de Tomara que Caia com Capuz", "colarinho americano", "Peças Tomara que Caia ou com Colarinho/Lapela não possuem capuz"),
				Arguments.of("Exceção de Decote Colarinho com Capuz","tomara que caia" ,"Peças Tomara que Caia ou com Colarinho/Lapela não possuem capuz" )
				);
	}
	
	@Test
	@DisplayName("Cadastro com Exceção de Decote Tomara que caia Com Cava: deveria devolver mensagem de ValidacaoTomaraQueCaiaNaoTemCava ")
	void testCadastrarRoupaValidacaoTomaraQueCaiaComCava() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setDecote("tomara que caia");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Peças tomara-que-caia não possuem cava", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	
	@ParameterizedTest(name= "{index} {0}: [tipoRoupa]={1}, [msgExcecao]={2}")
	@MethodSource("proveAtributosParaValidarExcecoesTipoRoupaCadastro")
	@DisplayName("Cadastro: Excecao Tipo De Roupa: deveria devolver mensagem de ValidacaoException")
	void testCadastrarRoupaValidacaoExcecoesTipoRoupa(String nomeTeste, String tipoRoupa, String msgExcecao) {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.setTipoRoupa(tipoRoupa);

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals(msgExcecao, response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	private static Stream<Arguments> proveAtributosParaValidarExcecoesTipoRoupaCadastro(){
		return Stream.of(
				Arguments.of("Exceção de Tipo De Roupa Inexistente", "colar", "TipoRoupa informado não existe"),
				Arguments.of("Exceção de Camisa sem Colarinho","camisa" ,"Camisas possuem decote colarinho" ),
				Arguments.of("Exceção de Poncho Com Manga","poncho" ,"Ponchos não possuem mangas" )
				);
	}

	
	
	@Test
	@DisplayName("Cadastro com Exceção de Manga Inexistente: deveria devolver mensagem de ValidacaoMangaExiste ")
	void testCadastrarRoupaValidacaoMangaInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setManga("teste");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Manga informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Decote Inexistente: deveria devolver mensagem de ValidacaoDecoteExiste ")
	void testCadastrarRoupaValidacaoDecoteInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setDecote("teste");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Decote informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Cava Inexistente: deveria devolver mensagem de ValidacaoCavaExiste ")
	void testCadastrarRoupaValidacaoCavaInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setCava("teste");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Cava informada não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Comprimento Inexistente: deveria devolver mensagem de ValidacaoComprimentoExiste ")
	void testCadastrarRoupaValidacaoComprimentoInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setComprimento("teste");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Comprimento informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Silhueta Inexistente: deveria devolver mensagem de ValidacaoSilhuetaExiste ")
	void testCadastrarRoupaValidacaoSilhuetaInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setSilhueta("teste");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Silhueta informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Fechamento Inexistente: deveria devolver mensagem de ValidacaoFechamentoExiste ")
	void testCadastrarRoupaValidacaoFechamentoInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setFechamento("teste");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Fechamento informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Barra Inexistente: deveria devolver mensagem de ValidacaoBarraExiste ")
	void testCadastrarRoupaValidacaoBarraInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setBarra("teste");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Barra informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	@Test
	@DisplayName("Cadastro com Exceção de Prega Inexistente: deveria devolver mensagem de ValidacaoPregaExiste ")
	void testCadastrarRoupaValidacaoPregaInexistente() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getModelagem().setPrega("Teste");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Id de Prega informado não existe", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	
	@Test
	@DisplayName("Cadastro com Exceção de Comprimento Top: deveria devolver mensagem de ValidacaoComprimentoTop ")
	void testCadastrarRoupaValidacaoComprimentoTop() {
		String tipoRoupa = "top";
		String comprimento = "abaixo do quadril";
		String msgExcecao = "Top possui comprimento na cintura ou acima";
		
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		roupaCadastro.setTipoRoupa(tipoRoupa);
		roupaCadastro.getParteDeCima().setComprimento(comprimento);

		ResponseEntity<String> responseCadastro = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupaCadastro),
				String.class);

		assertEquals(msgExcecao, responseCadastro.getBody());
		assertTrue(responseCadastro.getStatusCode().is4xxClientError());
		
		
	}
	
	
	@Test
	@DisplayName("Atualizar: Excecao Comprimento Top")
	void testAtualizarRoupaExcecaoComprimentoTop() {
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		restTemplate.postForEntity("/confeccao", roupaCadastro, Roupa.class);
		
		DadosAtualizaRoupaDTO roupa = criaRoupaAtualizar();
		roupa.setTipoRoupa("top");
		roupa.getParteDeCima().setComprimento("abaixo do quadril");
		ResponseEntity<String> response = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupa), String.class);
		

		assertEquals("Top possui comprimento na cintura ou acima", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	
	@Test
	@DisplayName("Cadastro com Exceção de Comprimento Jaqueta Colete Blazer: deveria devolver mensagem de ValidacaoComprimentoJaquetaColeteBlazer ")
	void testCadastrarRoupaValidacaoComprimentoJaqueta() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.setTipoRoupa("jaqueta");
		roupa.getParteDeCima().setComprimento("joelho");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Colete, Blazer e Jaqueta possuem comprimento acima do meio da coxa", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	@Test
	@DisplayName("Cadastro com Exceção de Comprimento Camisa e Camiseta : deveria devolver mensagem de ValidacaoComprimentoCamisetaECamisa ")
	void testCadastrarRoupaValidacaoComprimentoCamisaJoelho() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.setTipoRoupa("camisa");
		roupa.getParteDeCima().setDecote("colarinho italiano");
		roupa.getParteDeCima().setComprimento("joelho");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Camisas e Camisetas possuem comprimento acima do joelho", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	

	@Test
	@DisplayName("Cadastro com Exceção de Colete Sem Manga Regata: deveria devolver mensagem de ColeteTemMangaRegata ")
	void testCadastrarRoupaValidacaoColeteSemMangaRegata() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.setTipoRoupa("colete");
		roupa.getParteDeCima().setManga("regata alcinha");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Coletes possuem manga regata", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	@Test
	@DisplayName("Cadastro com Exceção de Colete Sem Manga Regata: deveria devolver mensagem de ColeteTemMangaRegata ")
	void testCadastrarRoupaValidacaoColeteComMangaRegataAlcinha() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.setTipoRoupa("colete");
		roupa.getParteDeCima().setManga("curta solta");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Coletes possuem manga regata", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	

	
	@Test
	@DisplayName("Cadastro com Exceção de Regata Sem Cava: deveria devolver mensagem de ValidacaoCavaExiste ")
	void testCadastrarRoupaValidacaoRegataSemCava() {
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.getParteDeCima().setCava("sem");

		ResponseEntity<String> response = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals("Peças regatas precisam possuir cava", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}

	
	@Test
	@DisplayName("Cadastro e Atualizar:  Exceção de TamanhoInicialMaiorTamanhoFinal")
	void testValidacaoExcecoesTamanhoRoupa() {
		Integer tamanhoInicial = 42;
		Integer tamanhoFinal = 34;
		String msgExcecao = "Tamanho Final precisa ser igual ou maior que Tamanho Inicial";
		
		DadosCadastroRoupaDTO roupa = criaRoupaCadastro();
		roupa.setTamanhoInicial(tamanhoInicial);
		roupa.setTamanhoFinal(tamanhoFinal);

		ResponseEntity<String> responseCadastro = restTemplate.exchange("/confeccao", HttpMethod.POST, new HttpEntity<>(roupa),
				String.class);

		assertEquals(msgExcecao, responseCadastro.getBody());
		assertTrue(responseCadastro.getStatusCode().is4xxClientError());
		
		DadosAtualizaRoupaDTO roupaAtualizar = criaRoupaAtualizar();
		roupaAtualizar.setTamanhoInicial(tamanhoInicial);
		roupaAtualizar.setTamanhoFinal(tamanhoFinal);

		ResponseEntity<String> responseAtualizar = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupaAtualizar), String.class);

		assertEquals(msgExcecao, responseAtualizar.getBody());
		assertTrue(responseAtualizar.getStatusCode().is4xxClientError());
		
		
	}
	
	
	@Test
	@DisplayName("Atualizar: deveria devolver codigo http 200 quando infos estao validas")
	void testAtualizarRoupaInfosValidas() {
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		restTemplate.postForEntity("/confeccao", roupaCadastro, Roupa.class);
		
		DadosAtualizaRoupaDTO roupa = criaRoupaAtualizar();
		Long[] fibras = {6l,7l,8l};
		roupa.getTecido().setIdDasFibras(fibras);

		ResponseEntity<DadosDetalhamentoRoupaDTO> response = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupa), DadosDetalhamentoRoupaDTO.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertEquals(3, response.getBody().tecido().getComposicao().size());
	}

	

	
	
	@ParameterizedTest(name= "{index} {0}: [tipoRoupa]={1}, [msgExcecao]={2}")
	@MethodSource("proveAtributosParaValidarExcecoesTipoRoupaAtualizar")
	@DisplayName("Atualizar: Excecao Tipo De Roupa: deveria devolver mensagem de ValidacaoException")
	void testAtualizarRoupaValidacaoExcecoes(String nomeTeste, String tipoRoupa, String msgExcecao) {
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		restTemplate.postForEntity("/confeccao", roupaCadastro, Roupa.class);
		
		DadosAtualizaRoupaDTO roupa = criaRoupaAtualizar();
		roupa.setTipoRoupa(tipoRoupa);
		ResponseEntity<String> response = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupa), String.class);
		
		assertEquals(msgExcecao, response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	private static Stream<Arguments> proveAtributosParaValidarExcecoesTipoRoupaAtualizar(){
		return Stream.of(
				Arguments.of("Excecao Tipo De Roupa Inexistente", "colar", "TipoRoupa informado não existe"),
				Arguments.of("Excecao Ponchos Nao Tem Manga","poncho" ,"Ponchos não possuem mangas" ),
				Arguments.of("Exceção de Camisa sem Colarinho","camisa" ,"Camisas possuem decote colarinho" )
				);
	}
	
	
	@Test
	@DisplayName("Atualizar: Excecao Comprimento Camisa e Camiseta")
	void testAtualizarRoupaExcecaoComprimentoCamisaCamiseta() {
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		restTemplate.postForEntity("/confeccao", roupaCadastro, Roupa.class);
		
		DadosAtualizaRoupaDTO roupa = criaRoupaAtualizar();
		roupa.setTipoRoupa("camisa");
		roupa.getParteDeCima().setDecote("colarinho italiano");
		roupa.getParteDeCima().setComprimento("abaixo do joelho");
		ResponseEntity<String> response = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupa), String.class);
		
		assertEquals("Camisas e Camisetas possuem comprimento acima do joelho", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	@Test
	@DisplayName("Atualizar: Excecao Comprimento Jaqueta Colete Blazer")
	void testAtualizarRoupaExcecaoComprimentoJaquetaColeteBlazer() {
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		restTemplate.postForEntity("/confeccao", roupaCadastro, Roupa.class);
		
		DadosAtualizaRoupaDTO roupa = criaRoupaAtualizar();
		roupa.getModelagem().setFechamento("ziper lateral");
		roupa.setTipoRoupa("jaqueta");
		roupa.getParteDeCima().setComprimento("joelho");
		ResponseEntity<String> response = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupa), String.class);
		
		assertEquals("Colete, Blazer e Jaqueta possuem comprimento acima do meio da coxa", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	
	@Test
	@DisplayName("Atualizar: Excecao Colete Tem Manga")
	void testAtualizarRoupaExcecaoColeteTemManga() {
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		restTemplate.postForEntity("/confeccao", roupaCadastro, Roupa.class);
		
		DadosAtualizaRoupaDTO roupa = criaRoupaAtualizar();
		roupa.setTipoRoupa("colete");
		roupa.getParteDeCima().setManga("regata alcinha");
		ResponseEntity<String> response = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupa), String.class);
		
		assertEquals("Coletes possuem manga regata", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
	
	

	
	@Test
	@DisplayName("Atualizar: Excecao Sem Fechamento Com Construcao Tecido ")
	void testAtualizarRoupaExcecaoSemFechamentoConstrucaoTecido() {
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		restTemplate.postForEntity("/confeccao", roupaCadastro, Roupa.class);
		
		DadosAtualizaRoupaDTO roupa = criaRoupaAtualizar();
		roupa.getModelagem().setFechamento("sem");
		roupa.getTecido().setConstrucao(ConstrucaoEnum.PLANO);
		roupa.getModelagem().setSilhueta("justa");
		ResponseEntity<String> response = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupa), String.class);
		
		assertEquals("Roupas sem fechamento precisam ter silhueta larga ou a construção do tecido precisa ser em malha", response.getBody());
		assertTrue(response.getStatusCode().is4xxClientError());
	}
		
	
	@ParameterizedTest
	@MethodSource("proveFibrasParaComposicaoTecidoParaValidacao")
	@DisplayName("Atualizar: Validando Atributos Tecido Passando Composicao de Fibras Diferentes")
	void testAtualizarRoupaInfosValidasParaValidacaoTecido(Long[] fibras, Integer length) {
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		restTemplate.postForEntity("/confeccao", roupaCadastro, Roupa.class);
		
		DadosAtualizaRoupaDTO roupa = criaRoupaAtualizar();
		roupa.getTecido().setIdDasFibras(fibras);

		ResponseEntity<DadosDetalhamentoRoupaDTO> response = restTemplate.exchange("/confeccao/atualizar",
				HttpMethod.PUT, new HttpEntity<>(roupa), DadosDetalhamentoRoupaDTO.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertEquals(length, response.getBody().tecido().getComposicao().size());
	}
	
	private static Stream<Arguments> proveFibrasParaComposicaoTecidoParaValidacao(){
		Long[] fibras = {3l,6l};
		Long[] fibras1 = {6l};
		Long[] fibras2 = {8l};
		Long[] fibras3 = {9l};
		Long[] fibras4 = {1l,9l};
		return Stream.of(
				Arguments.of(fibras, fibras.length),
				Arguments.of(fibras1, fibras1.length),
				Arguments.of(fibras2, fibras2.length),
				Arguments.of(fibras3, fibras3.length),
				Arguments.of(fibras4, fibras4.length)
				);
	}
	
	
	


	
	@Test
	@DisplayName("Listagem: deveria devolver codigo http 200 quando infos estao validas")
	void testListarRoupa() {

		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/listagem", Roupa.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());

	}
	
	
	@Test
	@DisplayName("Listagem de colecao: deveria devolver codigo http 200 quando infos estao validas")
	void testListarRoupaColecao() {
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		restTemplate.postForEntity("/confeccao", roupaCadastro, Roupa.class);
		
		ResponseEntity<Roupa> response = restTemplate.getForEntity("/confeccao/listagem/colecao/colecao%20teste", Roupa.class);

		assertTrue(response.getStatusCode().is2xxSuccessful());

	}
	
	
	@Test
	@DisplayName("Detalhar: deveria devolver codigo http 200 quando infos estao validas")
	void testDetalharRoupaPorIdValido() {
		DadosCadastroRoupaDTO roupaCadastro = criaRoupaCadastro();
		restTemplate.postForEntity("/confeccao", roupaCadastro, Roupa.class);

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
