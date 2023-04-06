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

import br.com.magna.confeccao.domain.modelagem.Silhueta;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SilhuetaControllerTest {

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    void testListarSilhueta() {
	    	ResponseEntity<List<Silhueta>> response = restTemplate.exchange("/silhuetas", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

	    
	    	assertTrue(response.getStatusCode().is2xxSuccessful());
	    }
	    


}