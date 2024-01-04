package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
public class RestAssuredPutRequest {

    private static String requestBody = " {\n" +
            " \"title\" : \"foo\",\n" +
            " \"body\" : \"bar\", \n" +
            " \"userId\" : \"1\", \n" +
            " \"id\" : \"1\" \n}";

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void putRequest(){
        Response response = given()
                .header("Content-Type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .extract().response();

        System.out.println("Response Code Is : " + response.statusCode());
        Assertions.assertEquals(200, response.statusCode());

        String response1 = response.getBody().toString();
        System.out.println(response1);

        System.out.println("Response Is : " + response.jsonPath().getString("title"));
        System.out.println("Response Is : " + response.jsonPath().getString("body"));
        System.out.println("Response Is : " + response.jsonPath().getString("userId"));
        System.out.println("Response Is : " + response.jsonPath().getString("id"));


        Assertions.assertEquals("foo", response.jsonPath().getString("title"));
        Assertions.assertEquals("bar", response.jsonPath().getString("body"));
        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
        Assertions.assertEquals("1", response.jsonPath().getString("id"));

    }
}
