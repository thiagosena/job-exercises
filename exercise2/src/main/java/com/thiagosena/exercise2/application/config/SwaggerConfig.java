package com.thiagosena.exercise2.application.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(@Value("${app.version}") String appVersion, ServletContext servletContext) {
        return new OpenAPI()
                .components(new Components())
                .servers(List.of(new Server()
                        .url(servletContext.getContextPath())
                        .description("VisualNuts Server URL -")))
                .info(new Info()
                        .title("VisualNuts Exercise2 API")
                        .version(appVersion)
                        .contact(new Contact()
                                .name("Thiago Sena")
                                .url("thiagosena.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("VisualNuts Exercise2 Github")
                        .url("https://github.com/thiagosena/visualnuts-exercises/tree/main/exercise2"));
    }
}
