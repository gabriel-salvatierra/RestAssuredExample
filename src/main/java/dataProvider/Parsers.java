package dataProvider;


import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Parsers {

    public static XmlPath rawToXML(Response r) {
        String response = r.asString();
        XmlPath x = new XmlPath(response);
        return x;
    }

    public static JsonPath rawToJSON(Response r) {
        String response = r.asString();
        JsonPath j = new JsonPath(response);
        return j;
    }
}
