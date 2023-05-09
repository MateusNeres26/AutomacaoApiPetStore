package petstore.modulos.pet;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.testBase.TestBase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class AtualizarAnimalTest extends TestBase {


        @Test
        @DisplayName("Atualizar dados de um pet existente - StatusCode 404")
        public void testAtualizarDadosDeUmPetExistenteComSucesso() {
            int petId = 243;

            // Faz a requisição PUT para atualizar os dados do pet
            given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "  \"id\": " + petId + ",\n" +
                            "  \"category\": {\n" +
                            "    \"id\": 243,\n" +
                            "    \"name\": \"NerinPet1\"\n" +
                            "  },\n" +
                            "  \"name\": \"NerinPet1\",\n" +
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
                    .body("category.name", equalTo("NerinPet1"))
                    .body("name", equalTo("NerinPet1"))
                    .body("status", equalTo("sold"));
        }

}
