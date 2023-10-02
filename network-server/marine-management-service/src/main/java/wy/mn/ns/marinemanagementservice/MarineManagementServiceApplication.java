package wy.mn.ns.marinemanagementservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "User Management Service REST API Documentation",
                description = "Service for managing user registration and account information",
                version = "v1",
                contact = @Contact(
                        name = "Damian Malecki",
                        email = "damian0malecki@gmail.com",
                        url = "https://www.TO_BE_ADDED.com"
                ),
                license = @License(
                        name = "Apache License 2.0",
                        url = "https://www.TO_BE_ADDED.com"
                )
        )
//        externalDocs = @ExternalDocumentation(
//                description = "",
//                url = ""
//        )
)
@SpringBootApplication
public class MarineManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarineManagementServiceApplication.class, args);
    }

}
