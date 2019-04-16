package basics;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class basics1 {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://postman-echo.com";

        given().
                param("foo1", "bar1").
                param("foo2", "bar2").
                when().
                get("/get").
                then().assertThat().statusCode(200);
    }
}
