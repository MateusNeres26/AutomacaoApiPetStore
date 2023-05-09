package petstore.modulos.store;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.dataFactory.CadastroDataFactory;
import petstore.testBase.TestBase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CadastroAnimalTest extends TestBase {
    @Test
    @DisplayName("Deve cadastrar novo pedido de pet com sucesso ")
    public void testCadastroNovoPedidoDePetComSucesso() {
        given()
            .contentType(ContentType.JSON)
                .body(CadastroDataFactory.setBody())
        .when()
            .post("/store/order")
        .then()
            .body("id", equalTo(1))
                .body("status", equalTo("placed"))
                    .statusCode(200)
                        .log().body();
    }
    @Test
    @DisplayName("Cadastrar novo pedido de pet sem sucesso - StatusCode 400")
    public void testCadastroNovoPedidoDePetSemSucesso() {
        given()
            .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": ,\n" + //Forçando entrada inválida para simulação de erro.//
                        "  \"petId\": 1,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \"2023-05-08T21:30:55.999Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
        .when()
            .post("/store/order")
        .then()
            .body("message", equalTo("bad input"))
                .statusCode(400)
                    .log().body();
    }
}
