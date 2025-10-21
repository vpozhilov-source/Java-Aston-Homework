import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class PostmanEchoTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testGetRequest() {
        Response response = given()
                .log().all()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().all()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("args.foo1"), "bar1");
        assertEquals(response.jsonPath().getString("args.foo2"), "bar2");
        assertTrue(response.jsonPath().getString("url").contains("https://postman-echo.com/get"));
    }

    @Test
    public void testPostRequestTextPlain() {
        String requestBody = "This is raw text data";

        Response response = given()
                .log().all()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .log().all()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("data"), requestBody);
        assertEquals(response.jsonPath().getString("url"), "https://postman-echo.com/post");
        assertTrue(response.jsonPath().getString("headers.content-type").contains("text/plain"));
    }

    @Test
    public void testPostRequestFormUrlencoded() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("name", "John");
        formParams.put("age", "30");
        formParams.put("city", "New York");

        Response response = given()
                .log().all()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .formParams(formParams)
                .when()
                .post("/post")
                .then()
                .log().all()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("form.name"), "John");
        assertEquals(response.jsonPath().getString("form.age"), "30");
        assertEquals(response.jsonPath().getString("form.city"), "New York");
        assertEquals(response.jsonPath().getString("url"), "https://postman-echo.com/post");
        assertTrue(response.jsonPath().getString("headers.content-type").contains("application/x-www-form-urlencoded"));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "{\"title\": \"Test\", \"completed\": false}";

        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .log().all()
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
                .log().all()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getBoolean("data.updated"), true);
        assertEquals(response.jsonPath().getString("url"), "https://postman-echo.com/patch");
    }

    @Test
    public void testDeleteRequest() {
        Response response = given()
                .log().all()
                .when()
                .delete("/delete")
                .then()
                .log().all()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("url"), "https://postman-echo.com/delete");
    }
}