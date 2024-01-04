package restassured;

import groovy.transform.SourceURI;

import static io.restassured.RestAssured.given;

public class MyFirstRestAssured {
        public static void getResponseBody(){

            given().queryParam("CUSTOMER_ID", "68125")
                    .queryParam("PASSWORD", "1234!")
                    .queryParam("Account_No", "1")
                    .when()
                    .get("http://demo.guru99.com/V4/sinkministatement.php")
                    .then()
                    .log()
                    .body();

        }

        public static void getResponseStatus(){

            int statusCode =  given()
                    .queryParam("CUSTOMER_ID", "68125")
                    .queryParam("PASSWORD", "1234!")
                    .queryParam("Account_No", "1")
                    .when()
                    .get("http://demo.guru99.com/V4/sinkministatement.php")
                    .getStatusCode();

            System.out.println("The response code is : " +statusCode);
            given().when().get("http://demo.guru99.com/V4/sinkministatement.php")
                    .then().assertThat().statusCode(200);

        }
    public static void main(String[] args){
        getResponseBody();
        getResponseStatus();
    }
}
