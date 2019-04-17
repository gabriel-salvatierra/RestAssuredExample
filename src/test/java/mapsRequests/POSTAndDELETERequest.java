package mapsRequests;

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

    public static String createPlace() {

        RestAssured.baseURI = FileReaderManager.getInstance().getConfigReader().getHost();

        Response createResponse = given().
                queryParam("key", FileReaderManager.getInstance().getConfigReader().getKey()).
                body(PayLoad.createPlaceBody()).
                when().
                post("/maps/api/place/add/json").
                then().assertThat().
                statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("status", equalTo("OK")).
                extract().response();

        String createResponseString = createResponse.asString();
        System.out.println(createResponseString);
        return createResponseString;
    }

    public static void deletePlace(String createResponseString) {

        JsonPath createResponseJSON = new JsonPath(createResponseString);
        String placeId = createResponseJSON.get("place_id");
        System.out.println("place_id to delete: " + placeId);

        given().
                queryParam("key", FileReaderManager.getInstance().getConfigReader().getKey()).
                body("{" +
                        "\"place_id\":\"" + placeId + "\"" +
                        "}").
                when().
                post(Resources.createPlaceResource()).
                then().assertThat().
                statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));
    }

    public static void main(String[] args) {

        deletePlace(createPlace());
    }
}
