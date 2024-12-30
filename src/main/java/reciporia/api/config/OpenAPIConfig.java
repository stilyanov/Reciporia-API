package reciporia.api.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openAPI = new OpenAPI();

        openAPI.setInfo(
                new Info()
                        .description("This is the Reciporia recipe micro service.")
                        .title("Reciporia recipes API")
                        .version("0.0.1")
                        .contact(
                                new Contact()
                                        .name("stilyanov")
                                        .email("stilyanov@gmail.com")
                        )
        );
        return openAPI;
    }

}
