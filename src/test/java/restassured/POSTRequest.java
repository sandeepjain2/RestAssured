package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class POSTRequest {

    @Test
    public void postRequest() {
        String jsonString = "{\"name\": \"kanak\", \"password\" : \"kanak123\"}";

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri("https://reqres.in/api/users");
        request.body(jsonString);
        Response response = request.post();
        System.out.println(response.asString());
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(201);
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
    }
}
