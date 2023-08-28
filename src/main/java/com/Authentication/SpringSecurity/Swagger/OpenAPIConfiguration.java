package com.Authentication.SpringSecurity.Swagger;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

@OpenAPIDefinition(

        info = @Info(
                contact = @Contact(
                        name = "Insert Name Here",
                        email = "Enter email here",
                        url = "Enter your webstie here"
                ),
                description = "OpenAPI documentation for Spring Security Starter Pack",
                title = "OpenAPI specfication",
                version = "1.0",
                license = @License(
                        name = "Enter license name if applicable",
                        url = "Enter applicable link"
                ),
                termsOfService = "Enter terms of service here"
        ),
        servers = {
                @Server(
                        description = "Local Development Environment",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Production Environment can go here",
                        url = "do not use localhost url for production"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "JWTBearer"
                )
        }
)

/**
 *  Declare the desired security schema
 *  Add a description if desired
 *
 *  The two important parts come from type and in
 *  Type is used to declare the type of Schema
 *  In is used to declare where the authentication comes from which in this case is the HTTP header
 */
@SecurityScheme(
            name = "JWTBearer",
            description = "JWT Bearer token in HTTP Headers",
            scheme = "bearer",
            type = SecuritySchemeType.HTTP,
            bearerFormat = "JWT",
            in = SecuritySchemeIn.HEADER
        )
public class OpenAPIConfiguration {

}
