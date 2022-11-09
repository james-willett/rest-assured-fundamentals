package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.BeforeClass;

public class TestConfig {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://videogamedb.uk/";
        RestAssured.basePath = "api/v2/";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json")
                .addHeader("Accept", "application/json")
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}
