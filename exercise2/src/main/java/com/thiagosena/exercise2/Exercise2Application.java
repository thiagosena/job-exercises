package com.thiagosena.exercise2;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class Exercise2Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercise2Application.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${app.version}") String appVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("VisualNuts Exercise2 API")
                        .version(appVersion)
                        .contact(new Contact()
                                .name("Thiago Sena")
                                .url("thiagosena.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("VisualNuts Exercise2 Github")
                        .url("https://github.com/thiagosena/visualnuts-exercises/tree/main/exercise2"));
    }

}
