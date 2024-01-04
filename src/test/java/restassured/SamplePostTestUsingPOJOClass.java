package restassured;

import io.restassured.http.ContentType;
import org.apache.http.protocol.ResponseDate;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.given;

public class SamplePostTestUsingPOJOClass {

    @Test
    public void createUser_whenSuccess(){
        CreateUserDo cu = new CreateUserDo();
        cu.setName("Sandeep");
        cu.setGender("Male");
        cu.setStatus("Active");

        String response = given().log().all()
                .header("authorization", "Bearer0421655cfe7ba40a791e0ce32d83ad33363348919c11627f409a3228f205e15f")
                .accept(ContentType.JSON)
                .contentType("application/json")
                .and()
                .body(cu)
                .post("https://gorest.co.in/public-api/users")
                .thenReturn().asString();

        System.out.println(response);

        // Converting response body to object
/*
        ResponseDataObjects responseDataObjects = given()
                .log()
                .all()
                .header("authorization", "Bearer0421655cfe7ba40a791e0ce32d83ad33363348919c11627f409a3228f205e15f")
                .accept(ContentType.JSON)
                .contentType("application/json")
                .and()
                .body(cu)
                .post("https://gorest.co.in/public-api/users")
                .thenReturn().as(ResponseDataObjects.class);*/
    }
}
