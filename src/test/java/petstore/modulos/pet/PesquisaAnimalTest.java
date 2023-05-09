package petstore.modulos.pet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.testBase.TestBase;
import java.io.File;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

public class PesquisaAnimalTest extends TestBase {
    @Test
    @DisplayName("Deve pesquisar por um pet inexistente ")
    public void testPesquisarPorUmPetInexistenteComSucesso() {
        int petId = 555;

            given()
                .contentType(ContentType.JSON)
            .when()
                .get("/pet/" + petId)
            .then()
                .body("message", equalTo("Pet not found"))
                    .statusCode(404)
                        .log().body();
    }

    @Test
    @DisplayName("Deve pesquisar por pets com status pending")
    public void testPesquisarPorPetsComStatusPendente() {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("status", "pending")
            .when()
                .get("/pet/findByStatus");
        if (response.jsonPath().getList("$").size() == 0) {
            response.then().statusCode(200).body(equalTo("[]"))
                .log().body();
        } else {
            response.then().statusCode(200).body(matchesJsonSchema(new File("schema.json")))
                .log().body();
        }
    }
}




