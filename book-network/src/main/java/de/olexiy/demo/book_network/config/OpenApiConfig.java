package de.olexiy.demo.book_network.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.Setter;

@OpenAPIDefinition(
        info = @Info(
                title = "Book Social Network API",
                version = "1.0",
                contact = @Contact(
                        name = "Olexiy Sokurenko",
                        email = "olexiy.sokurenko@gmail.com",
                        url = "https://olexiy.it"
                ),
                description = "API for the Book Social Network"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8088/api/v1",
                        description = "Local ENV"
                ),
                @Server(
                        url = "https://book-network-olexiy.herokuapp.com/api/v1",
                        description = "Production ENV"
                )
        },
        security = {
                @SecurityRequirement(name = "bearerAuth")
        }

)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT Bearer authentication",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}

