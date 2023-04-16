package br.com.magna.confeccao.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocConfigurations {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
					.info(new Info().title("Confeccao API").description(
						"API Rest da aplicação Confecção, contendo as funcionalidades de CRUD de peças de roupa superiores.\n\n"
						+ "Suas operações permitem o mapeamento do  ")
						.contact(new Contact().name("Desenvolvedora").email("mmorilhas@gmail.com"))
						
							
							);
	}

}