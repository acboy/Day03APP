package main;

import org.json.*;

/**
 * Created by K02 on 2017-06-28.
 */


public class JsonAPP {
    public static void main(String[] args) throws JSONException {
        String Json = "{\"name\":\"www\",\"age\":20,\"height\":\"185.12\"}";

        JSONObject obj = new JSONObject(Json);
        String name = obj.getString("name");

        int age = obj.getInt("age");

        float height = (float) obj.getDouble("height");

        System.out.print("name:"+name+"age:"+age+"height:"+height);
    }
}
