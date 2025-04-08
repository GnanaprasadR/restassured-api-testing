package tests;

import base.BaseTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class PostTests extends BaseTest {

    @Test
    public void createPost() {
        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .header("Content-type", "application/json")
            .body(requestBody)
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("title", equalTo("foo"));
    }
}