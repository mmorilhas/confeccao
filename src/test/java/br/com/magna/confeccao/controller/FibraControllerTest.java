package br.com.magna.confeccao.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.confeccao.entities.domain.fibra.FibraDomain;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FibraControllerTest {

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    void testListarFibras() {
	    	ResponseEntity<FibraDomain> response = restTemplate.getForEntity("/fibras", FibraDomain.class);

	    	assertEquals(HttpStatus.OK, response.getStatusCode());
			assertNotNull(response.getBody());
	    }
	    


}
