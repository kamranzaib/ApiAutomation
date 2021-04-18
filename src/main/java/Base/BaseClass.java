package Base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class BaseClass {

    public static Response response;


    public static void verifyResponseCode200(int actual)

    {
        Assert.assertEquals(actual, 200);
    }


    public static void verifyResponseCode(int actual,int expected)

    {
        Assert.assertEquals(actual, expected);
    }

    public static JsonPath JSONParser(String response)
    {
        JsonPath json=new JsonPath(response);
        return json;
    }

    public static void verifyJsonData(String response,String key,String value)

    {
        JsonPath json=new JsonPath(response);
        String data= json.getString(key);
        Assert.assertEquals(data, value);
    }

    public static void ListJsonValues(String Endpoint, String value)

    {
        ArrayList<Map<String, ?>> body = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(Endpoint)
                .then()
                .extract()
                .response()
                .path(value);

        System.out.println(body);
    }

    public static Map<String, Object> postProduct(String name, String type, int price, int shipping, String upc, String description,
    String manufacturer, String model, String url, String image){

        //JSONObject jsonobject = new JSONObject();
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("name", name);
        body.put("type", type);
        body.put("price", price);
        body.put("shipping",shipping);
        body.put("upc", upc);
        body.put("description", description);
        body.put("manufacturer", manufacturer);
        body.put("model", model);
        body.put("url", url);
        body.put("image", image);

        return body;

    }

    public static Map<String, Object> postCategory(String name, String id){
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("name", name);
        body.put("id", id);

        return body;
    }


  public static void DeleteCategory(String url){

       String ToDelete = String.format("http://localhost:3030/categories/%s", url);

        response = given().when().delete(ToDelete).then().extract().response();

        Assert.assertEquals( response.statusCode(), 200);




  }


    }
