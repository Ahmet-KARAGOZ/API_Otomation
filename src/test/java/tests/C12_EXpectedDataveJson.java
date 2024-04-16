package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
       https://restful-booker.herokuapp.com/booking url'ine
       asagidaki body'ye sahip bir POST request gonderdigimizde
       donen response'un bookingid haric asagidaki gibi oldugunu test edin.

       Request body
       {
       "firstname" : "Hasan",
       "lastname" : "Yagmur",
       "totalprice" : 500,
       "depositpaid" : false,
       "bookingdates" : {
           "checkin" : "2021-06-01",
           "checkout" : "2021-06-10"
           },
       "additionalneeds" : "wi-fi"
       }

       Expected Response Body
       {
       "bookingid":24,
       "booking":{
           "firstname":"Hasan",
           "lastname":"Yagmur",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
               "checkin":"2021-06-01",
               "checkout":"2021-06-10"
               },
       "additionalneeds":"wi-fi"
       }
       }
        */
public class C12_EXpectedDataveJson {
    @Test
    public void expected(){
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin" , "2021-06-01");
        bookingDates.put("checkout" , "2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname","Hasan");
        reqBody.put("lastname","Yagmur");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingDates);
        reqBody.put("additionalneeds","wi-fi");

        JSONObject expData = new JSONObject();
        expData.put("bookingid",24);
        expData.put("booking" , reqBody);

        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        JsonPath respJP = response.jsonPath();
        Assert.assertEquals(expData.getJSONObject("booking").get("firstname"), respJP.get("booking.firstname") );

    }
}
