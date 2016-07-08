package br.com.lel.infraestrutura.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration // Define a classe como classe de configuração.
@EnableAutoConfiguration // Habilita a autoconfiguração.
@EnableSwagger // Habilita o Swagger.
@ComponentScan(basePackages = { "br.com.lel" })
public class GerenciadorMicroServicos {

	// Injeta uma instancia de SpringSwaggerConfig
	@Autowired
	private SpringSwaggerConfig swaggerConfig;

	public static void main(String[] args) throws Exception {
		// SpringApplication.run(GerenciadorMicroServicos.class, args);
		new SpringApplicationBuilder(GerenciadorMicroServicos.class).web(true).run(args);
	}

	@Bean
	public SwaggerSpringMvcPlugin groupOnePlugin() {
		return new SwaggerSpringMvcPlugin(swaggerConfig)
				// Adiciona as configurações do Swagger ao
				// SwaggerSpringMvcPlugin
				.apiInfo(apiInfo()) // Adiciona as propriedades de configuração
				.includePatterns("/gerenciadorMonitoramentoDiabetico.*?") // Habilita o
																// Swagger para
																// os nossos 2
																// endpoints
				.swaggerGroup("admin");
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo( // Configurações de contato, licença etc
										// não nescessáriamente precisa ser
										// definida
				"Swagger - Sistema de Controle de Diabetes",
				"Os serviços dessa aplicação permite realizar vários controle referentes ao diabetes.",
				"Free to use and mess around", "lincolnfcoelho@gmail.com", "Open Licence", "lincolnfcoelho@gmail.com");
		return apiInfo;
	}

}
