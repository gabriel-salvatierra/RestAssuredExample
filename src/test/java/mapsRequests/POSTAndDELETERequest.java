package mapsRequests;

import dataProvider.Parsers;
import dataProvider.PayLoad;
import dataProvider.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import managers.FileReaderManager;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POSTAndDELETERequest {

    public static JsonPath createPlace() {

        RestAssured.baseURI = FileReaderManager.getInstance().getConfigReader().getHost();

        Response createResponse = given().
                queryParam("key", FileReaderManager.getInstance().getConfigReader().getKey()).
                body(PayLoad.getPlaceBody()).
                when().
                post("/maps/api/place/add/json").
                then().assertThat().
                statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("status", equalTo("OK")).
                extract().response();

        String createResponseString = createResponse.asString();
        System.out.println(createResponseString);
        return Parsers.rawToJSON(createResponse);
    }

    public static void deletePlace(JsonPath responseJSON) {

        String idToDelete = responseJSON.get("place_id");
        System.out.println("place_id to delete: " + idToDelete);

        given().
                queryParam("key", FileReaderManager.getInstance().getConfigReader().getKey()).
                body("{" +
                        "\"place_id\":\"" + idToDelete + "\"" +
                        "}").
                when().
                post(Resources.deletePlaceResource()).
                then().assertThat().
                statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));
    }

    public static void main(String[] args) {

        deletePlace(createPlace());
    }
}
