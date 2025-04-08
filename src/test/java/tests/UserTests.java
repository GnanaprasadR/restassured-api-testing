package tests;

import base.BaseTest;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserTests extends BaseTest {

    @Test
    public void getPostById() {
        getTest().info("Starting test: getPostById");

        Response response = given()
                .log().all() // logs request details to console
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1");

        getTest().info("Sent GET request to /posts/1");

        int statusCode = response.getStatusCode();
        getTest().info("Received response with status code: " + statusCode);

        String responseBody = response.getBody().asPrettyString();
        getTest().info("Response Body:\n" + responseBody);

        if (statusCode == 200) {
            getTest().pass("Status code is 200 - OK");
        } else {
            getTest().fail("Unexpected status code: " + statusCode);
        }

        String title = response.jsonPath().getString("title");
        getTest().info("Post title: " + title);
    }

    @Test
    public void getAllUsers() {
        getTest().info("Starting test: getAllUsers");

        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .log().all()
                .when()
                .get("/users");

        getTest().info("Sent GET request to /users");

        int statusCode = response.getStatusCode();
        getTest().info("Status Code: " + statusCode);

        String responseBody = response.getBody().asPrettyString();
        getTest().info("Response Body:\n" + responseBody);

        if (statusCode == 200) {
            getTest().pass("Received expected status code 200");
        } else {
            getTest().fail("Expected status code 200 but got: " + statusCode);
        }

        int userCount = response.jsonPath().getList("$").size();
        getTest().info("Number of users: " + userCount);
        if (userCount == 10) {
            getTest().pass("Verified that user count is 10");
        } else {
            getTest().fail("Expected 10 users but got: " + userCount);
        }

        String email = response.jsonPath().getString("[0].email");
        getTest().info("First user email: " + email);
        if (email.contains("@")) {
            getTest().pass("First user email contains '@'");
        } else {
            getTest().fail("First user email does not contain '@': " + email);
        }
    }

    @Test
    public void getUserById() {
        getTest().info("Starting test: getUserById");

        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .log().all()
                .when()
                .get("/users/1");

        getTest().info("Sent GET request to /users/1");

        int statusCode = response.getStatusCode();
        getTest().info("Status Code: " + statusCode);

        String responseBody = response.getBody().asPrettyString();
        getTest().info("Response Body:\n" + responseBody);

        if (statusCode == 200) {
            getTest().pass("Received expected status code 200");
        } else {
            getTest().fail("Expected status code 200 but got: " + statusCode);
        }

        String username = response.jsonPath().getString("username");
        getTest().info("Username: " + username);
        if ("Bret".equals(username)) {
            getTest().pass("Username is Bret as expected");
        } else {
            getTest().fail("Expected username to be 'Bret' but got: " + username);
        }
    }
}