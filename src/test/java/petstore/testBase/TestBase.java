package petstore.testBase;

import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class TestBase {
    @BeforeEach
    public void beforeEach() {
        baseURI = "https://petstore.swagger.io/";
        basePath = "/v2";
    }
}
