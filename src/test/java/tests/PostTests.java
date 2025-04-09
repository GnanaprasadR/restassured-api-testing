package tests;

import base.BaseTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostTests extends BaseTest {

    @Test
    public void createPost() {
        getTest().info("Starting test: createPost");

        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}";

        getTest().info("Request Body:\n" + requestBody);

        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-type", "application/json")
                .log().all() // logs request
                .body(requestBody)
                .when()
                .post("/posts");

        getTest().info("Sent POST request to /posts");

        int statusCode = response.getStatusCode();
        getTest().info("Received status code: " + statusCode);

        String responseBody = response.getBody().asPrettyString();
        getTest().info("Response Body:\n" + responseBody);

        if (statusCode == 201) {
            getTest().pass("Status code is 201 - Created");
        } else {
            getTest().fail("Expected status code 201 but got: " + statusCode);
        }

        Integer id = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");

        if (id != null) {
            getTest().pass("Post ID is present: " + id);
        } else {
            getTest().fail("Post ID is null or missing");
        }

        if ("foo".equals(title)) {
            getTest().pass("Title matches expected value 'foo'");
        } else {
            getTest().fail("Title mismatch. Expected 'foo', got: " + title);
        }
    }
}