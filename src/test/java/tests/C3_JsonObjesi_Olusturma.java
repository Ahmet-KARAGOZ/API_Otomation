package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C3_JsonObjesi_Olusturma {
    /*
C3_JsonObjesiOlusturma
Asagidaki JSON Objesini olusturup konsolda yazdirin.
          {
          "title":"Ahmet",
          "body":"Merhaba",
          "userId":1
          }
 */
    @Test
    public void json01(){
        JSONObject jsonData = new JSONObject();
        jsonData.put("title" , "Ahmet");
        jsonData.put("body" , "Merhaba");
        jsonData.put("userId" , 1);

        System.out.println("Json Data Info : " + jsonData);



    }

    @Test
    public void json02(){
        /*
        {
    "firstname":"Jim",
    "additionalneeds":"Breakfast",
    "bookingdates": {
            "checkin":"2018-01-01",
            "checkout":"2019-01-01"
 },
     "totalprice":111,
     "depositpaid":true,
     "lastname":"Brown"
 }
         */
        JSONObject innerData = new JSONObject();
            innerData.put("checkin" , "2018-01-01");
            innerData.put("checkout","2019-01-01");

        JSONObject jsonData = new JSONObject();
            jsonData.put("firstname","Jim");
            jsonData.put("lastname","Brown");
            jsonData.put("bookingdates" , innerData);
            jsonData.put("totalprice" , 111);
            jsonData.put("depositpaid" , true);
            jsonData.put("additionalneeds" , "Breakfast");

        System.out.println("Json Data2 : " + jsonData);
    }


}
