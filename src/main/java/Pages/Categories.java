package Pages;

import dataProvider.DataProvider;
import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import sun.jvm.hotspot.utilities.Assert;

public class Categories extends Base.BaseClass {

    DataProvider data = new DataProvider();
    String url = data.getCateogories();
    Response resp = RestAssured.get(url);
    JsonPath js = resp.jsonPath();


    public void getCateogories(){

        verifyResponseCode200(resp.getStatusCode());

    }

    //change ID to unique ID by default it is now unique id but after 1 run it needs to be changed
    public void PostCateogories(){

        resp = RestAssured.given().contentType("application/json").accept("application/json")
                .body(postCategory("Apple", "09475925"))
                .when().post(url).then().extract().response();


             System.out.println(resp.getBody().asString());
             verifyResponseCode(resp.getStatusCode(), 201);

    }

    public void DeletCategory(){
        //Paste same id here
        DeleteCategory("09475925");


    }

}
