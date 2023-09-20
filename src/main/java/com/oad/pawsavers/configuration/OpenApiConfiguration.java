package com.oad.pawsavers.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Pawsavers API",
                description = "Non-profit Backend application for pet refuge management and adoption.",
                contact = @Contact(
                        name = "Omar Arias",
                        email = "omar.arias.dev@gmail.com"
                )
        )
)
public class OpenApiConfiguration {
}
