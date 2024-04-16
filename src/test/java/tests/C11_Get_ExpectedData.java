package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda
    donen response body'sinin asagida verilen ile ayni oldugunu test ediniz

    Response body :

    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }

 */
public class C11_Get_ExpectedData {
    @Test
    public void expected(){
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        JSONObject expData = new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        Response response = given().when().get(url);

        JsonPath respJP = response.jsonPath();

        Assert.assertEquals(expData.get("userId") , respJP.get("userId"));
        Assert.assertEquals(expData.get("id") , respJP.get("id"));
        Assert.assertEquals(expData.get("title") , respJP.get("title"));
        Assert.assertEquals(expData.get("body") , respJP.get("body"));


    }
}
