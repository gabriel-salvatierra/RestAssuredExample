package booksRequests;

import io.restassured.RestAssured;
import managers.FileReaderManager;
import testDataTypes.Book;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class POSTBook {

    public static void postABook(String bookName) {
        RestAssured.baseURI = FileReaderManager.getInstance().getConfigReader().getHost();
        Book bookToPost = FileReaderManager.getInstance().getJSONReader().getBookByName(bookName);

        given().
                body(bookToPost).
        when().
                post("/Library/Addbook.php").
        then().
                assertThat().statusCode(200).and().
                body("Msg", equalTo("successfully added")).log().body();
    }

    // Usar un enum para el recurso

    public static void main(String[] args) {

        postABook("Best Book");
    }
}
