package mapsRequests;

import dataProvider.Parsers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import managers.FileReaderManager;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GETRequest {

    public static void GETAllPlacesNames() {

        RestAssured.baseURI = FileReaderManager.getInstance().getConfigReader().getHost();

        System.out.println("Response:");
        Response createResponse = given().
                param("location", "-33.8670522,151.1957362").
                param("radius", "500").
                param("key", FileReaderManager.getInstance().getConfigReader().getKey()).
                when().
                get("/maps/api/place/nearbysearch/json").
                then().assertThat().
                statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("results[0].name", equalTo("Sydney")).and().
                body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).
                log().body().
                extract().response();

        JsonPath responseJSON = Parsers.rawToJSON(createResponse); // crear una clase a partir del JSON

        int resultsSize = responseJSON.get("results.size()");
        for (int i = 0; i < resultsSize; i++) {
            System.out.println((String) responseJSON.get("results[" + i + "].name"));
        }
    }

    public static void main(String[] args) {
        GETAllPlacesNames();
    }
}
