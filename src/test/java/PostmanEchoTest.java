import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class PostmanEchoTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        Response response = given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("args.foo1"), "bar1");
        assertEquals(response.jsonPath().getString("args.foo2"), "bar2");
        assertTrue(response.jsonPath().getString("url").contains("https://postman-echo.com/get"));
    }

    @Test
    public void testPostRequest() {
        String requestBody = "{\"name\": \"John\", \"age\": 30}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("data.name"), "John");
        assertEquals(response.jsonPath().getInt("data.age"), 30);
        assertEquals(response.jsonPath().getString("url"), "https://postman-echo.com/post");
        assertEquals(response.jsonPath().getString("headers.content-type"), "application/json");
    }

    @Test
    public void testPutRequest() {
        String requestBody = "{\"title\": \"Test\", \"completed\": false}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("data.title"), "Test");
        assertEquals(response.jsonPath().getBoolean("data.completed"), false);
        assertEquals(response.jsonPath().getString("url"), "https://postman-echo.com/put");
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "{\"updated\": true}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getBoolean("data.updated"), true);
        assertEquals(response.jsonPath().getString("url"), "https://postman-echo.com/patch");
    }

    @Test
    public void testDeleteRequest() {
        Response response = given()
                .when()
                .delete("/delete")
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("url"), "https://postman-echo.com/delete");
    }
}