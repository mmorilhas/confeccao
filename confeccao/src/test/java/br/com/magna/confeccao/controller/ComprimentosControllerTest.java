package br.com.magna.confeccao.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.confeccao.domain.partecima.Cava;
import br.com.magna.confeccao.domain.partecima.ComprimentoParteCima;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComprimentosControllerTest {

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    public void testListarComprimentos() {
	    	ResponseEntity<List<ComprimentoParteCima>> response = restTemplate.exchange("/comprimentos", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

	    
	    	assertTrue(response.getStatusCode().is2xxSuccessful());
	    }
	    


}
