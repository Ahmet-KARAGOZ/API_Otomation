package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
/*
{
"firstName": "John",
"lastName": "doe",
"age": 26,
"address": {
    "streetAddress": "naist street",
    "city": "Nara",
    "postalCode": "630-0192"
            },
"phoneNumbers": [
                {
                    "type": "iPhone",
                    "number": "0123-4567-8888"
                },
                {
                    "type": "home",
                    "number": "0123-4567-8910"
                }
                ]
}


 */
public class C8_JSON_Path_Kullanimi {
    @Test
    public void jsonPath(){
        JSONObject iPhoneTel = new JSONObject();
        iPhoneTel.put("type" , "iPhone");
        iPhoneTel.put("number" , "0123-4567-8888");

        JSONObject iHomeTel = new JSONObject();
        iHomeTel.put("type" , "home");
        iHomeTel.put("number" , "0123-4567-8910");

        JSONObject adress = new JSONObject();
        adress.put("streetAddress" , "naist street");
        adress.put("city" , "Nara");
        adress.put("postalCode" , "630-0192");

        JSONArray phoneNumbers = new JSONArray();
        phoneNumbers.put(0 , iPhoneTel);
        phoneNumbers.put(1 , iHomeTel);

        JSONObject personalInfo = new JSONObject();

        personalInfo.put("firstName" , "John");
        personalInfo.put("lastName" , "doe");
        personalInfo.put("age" ,  26);
        personalInfo.put("address" , adress);
        personalInfo.put("phoneNumbers" , phoneNumbers);

        System.out.println("İsim : " + personalInfo.get("firstName"));
        System.out.println("lastName : " + personalInfo.get("lastName"));
        System.out.println("age : " + personalInfo.get("age"));

        System.out.println("Phone Number : " + personalInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("type")
                                             + personalInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("number")
                                             + personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("type")
                                             + personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));

        System.out.println("Adress : " + personalInfo.getJSONObject("address").get("streetAddress")
                                        + personalInfo.getJSONObject("address").get("city")
                                        + personalInfo.getJSONObject("address").get("postalCode"));
    }
}
