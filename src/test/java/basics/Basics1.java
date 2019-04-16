package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics1 {

    public static void Test() {
        RestAssured.baseURI = "https://postman-echo.com";

        given().
                param("foo1", "bar1").
                param("foo2", "bar2").
                when().
                get("/get").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("headers.x-forwarded-port", equalTo("443")).and().
                body("headers.accept-encoding", equalTo("gzip,deflate"));
    }
}
