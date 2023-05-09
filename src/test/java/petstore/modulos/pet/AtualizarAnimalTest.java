package petstore.modulos.pet;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.testBase.TestBase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class AtualizarAnimalTest extends TestBase {


        @Test
        @DisplayName("Deve atualizar dados de um pet existente")
        public void testAtualizarDadosDeUmPetExistenteComSucesso() {
            Faker faker = new Faker();
            String name = faker.name().firstName();
            int petId = 243;

            given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "  \"id\": " + petId + ",\n" +
                            "  \"category\": {\n" +
                            "    \"id\": 243,\n" +
                            "    \"name\": \"" + name + "\"\n" +
                            "  },\n" +
                            "  \"name\": \"" + name + "\",\n" +
                            "  \"photoUrls\": [\n" +
                            "    \"string\"\n" +
                            "  ],\n" +
                            "  \"tags\": [\n" +
                            "    {\n" +
                            "      \"id\": 0,\n" +
                            "      \"name\": \"string\"\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"status\": \"sold\"\n" +
                            "}")
                    .when()
                    .put("/pet/")
                .then()
                    .statusCode(200);

            // Faz a requisição GET para verificar se as informações do pet foram atualizadas
            given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/pet/" + petId)
                .then()
                    .statusCode(200)
                        .body("category.name", equalTo(name))
                            .body("name", equalTo(name))
                                .body("status", equalTo("sold"))
                                    .log().body();
        }

}
