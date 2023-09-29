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
		return new OpenAPI().info(new Info().title("Confeccao API").description("""
				API Rest da aplicação Confecção.
				Simplifica a comunicação entre marca e confecção: 
				o sistema visa facilitar a consulta feita pela confecção dos dados técnicos que são geralmente enviados no desenho técnico e manter um histórico das modelagens criadas pela marca.
				Contém as funcionalidades de CRUD de peças de roupa superiores.
				""")
				.contact(new Contact().name("Desenvolvedora").email("mmorilhas@gmail.com"))

		);
	}

}