package Pages;

import Base.BaseClass;
import dataProvider.DataProvider;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import java.util.ArrayList;
import java.util.Map;


import static io.restassured.RestAssured.given;


public class Products extends Base.BaseClass {

    DataProvider data = new DataProvider();
    String url = data.getProducts();
    Response resp = RestAssured.get(url);
    JsonPath js = resp.jsonPath();


    public void GetStatusCode() {

        int statuscode = resp.getStatusCode();
        System.out.println(statuscode);
        BaseClass.verifyResponseCode200(statuscode);

    }

    public void VerifyProductType() {

        ArrayList<Map<String, ?>> cards = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract()
                .response()
                .path("data.type");

        for(int i =0; i<cards.size(); i++){

            Assert.assertEquals(cards.get(i), "HardGood");

}
    }


   public void ProductNames() {

       BaseClass.ListJsonValues(url, "data.name");

   }

    public void PostProduct(){

        resp = RestAssured.given().contentType("application/json").accept("application/json")
                .body(postProduct("Apple", "headphones", 249, 15, "12034511", "in ear headphoens", "Apple", "MN2400B4Z",
                        "http://www.bestbuy.com/site/apple-airpods-pro-white/5706659.p?skuId=5706659", "PNG"))
                .when().post(url).then().extract().response();

        System.out.println(resp.getBody().asString());
        verifyResponseCode(resp.getStatusCode(), 201);



    }


}
