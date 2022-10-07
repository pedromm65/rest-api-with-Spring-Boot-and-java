package br.com.pedrohlimadev.integrationtests.swagger;

import br.com.pedrohlimadev.configs.TestConfigs;
import br.com.pedrohlimadev.integrationtests.testcontainer.AbstractIntegrationTest;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void showDisplaySwaggerUiPage() {
        var content = given().basePath("/swagger-ui/index.html")
                .port(TestConfigs.SERVER_PORT)
                .when()
                    .get()
                .then()
                    .statusCode(200)
                .extract()
                    .body()
                        .asString();


        assertTrue(content.contains("Swagger UI"));
    }


}
