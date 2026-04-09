package com.github.sergiocostaczr.petshopapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Petshop API")
                        .description("API para gerenciamento de clientes, pets e profissionais de um petshop")
                        .version("1.0.0")
                );
    }
}
