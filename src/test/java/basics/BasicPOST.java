package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BasicPOST {

    public static void BasicPOSTMethod() {
        RestAssured.baseURI = "https://postman-echo.com";

        given().
                body("{" +
                        "\"foo1\": \"bar1\"" +
                        "\"foo2\": \"bar2\"" +
                        "}").
                when().
                post("/post").
                then().assertThat().
                statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("url", equalTo("https://postman-echo.com/post"));
    }

    public static void main(String[] args) {
        BasicPOSTMethod();
    }
}
