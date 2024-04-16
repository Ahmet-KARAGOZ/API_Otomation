package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C6_Post_Response_BodyTesti {
    /*

       https://jsonplaceholder.typicode.com/posts url'ine asagidaki body ile bir POST request gonderdigimizde
                   {
                   "title":"API",
                   "body":"API ogrenmek ne guzel",
                    "userId":10,
                   }
    donen Response'un,
           status code'unun 201,
           ve content type'inin application/json
           ve Response Body'sindeki,
              "title"'in "API" oldugunu
              "userId" degerinin 100'den kucuk oldugunu
              "body" nin "API" kelimesi icerdigini
           test edin.
        */
    @Test
    public void post02(){
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject jsonData = new JSONObject();
        jsonData.put("title" , "API");
        jsonData.put("body" , "API ogrenmek ne guzel");
        jsonData.put("userId" , 97);

        Response response = given().contentType(ContentType.JSON).when().body(jsonData.toString()).post(url);

        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json; charset=utf-8")
                .body("title" , Matchers.equalTo("API"))
                .body("userId" , Matchers.lessThan(100))
                .body("body" , Matchers.containsString("API"));

        System.out.println(response.prettyPrint());
    }
}
