package petstore.modulos.pet;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.testBase.TestBase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PesquisaAnimalTest extends TestBase {
    @Test
    @DisplayName(" Pesquisar por um pet inexistente - StatusCode 404")
    public void testPesquisarPorUmPetInexistenteComSucesso() {
        int petId = 555;

            given()
                .contentType(ContentType.JSON)
            .when()
                .get("/pet/" + petId)
            .then()
                .body("message", equalTo("Pet not found"))
                    .statusCode(404);

    }

    @Test
    @DisplayName("Pesquisar por pets com status pending - StatusCode 200")
    public void testPesquisarPorPetsComStatusPendente(){

        given()
            .contentType(ContentType.JSON)
                .queryParam("status", "pending")
        .when()
            .get("/pet/findByStatus")
        .then().assertThat()
                .statusCode(200)
                //Atualização constante dos nomes ou ids
                .body("[0].name", equalTo("Json Whiskers"))
                .body("[1].name", equalTo("doggie"));

    }
}




