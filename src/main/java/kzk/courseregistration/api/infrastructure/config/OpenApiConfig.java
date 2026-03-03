package kzk.courseregistration.api.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI courseRegistrationOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Course Registration System API")
                        .description("API for managing courses, students, teachers, and subjects using Clean Architecture.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
