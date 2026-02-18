package com.caincabrera.meat_manager.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Meat Manager API",
                version = "1.0.0",
                description = "REST API for managing butcher shop operations, including clients, products, and suppliers.",
                contact = @Contact(
                        name = "Cain Cabrera",
                        email = "cain.cabrera.work@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local environment"
                )
        }
)

@Configuration
public class OpenAPIConfig {
}
