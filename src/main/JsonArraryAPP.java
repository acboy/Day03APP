package main;

import bean.Person;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by K02 on 2017-06-28.
 */

public class JsonArraryAPP {
    public static void main(String[] args) throws JSONException {
        String  json = newJsonArrary();

        JSONArray array = new JSONArray(json);

        JSONObject obj = new JSONObject();
        obj.put("total",array.length());
        obj.put("data",array);

        json = obj.toString();
        //将json字符串转换成字符串对象

        System.out.println(json);

        parseJson(json);
    }

    public static String newJsonArrary() throws JSONException {
        JSONArray arrary= new JSONArray();

        JSONObject obj= null;

        for (int i=0;i<5;i++){
            obj = new JSONObject();
            obj.put("name","obj-name"+i);
            obj.put("age",(int)(Math.random()*6+20));

            arrary.put(obj);
        }

        return arrary.toString();
    }

    public static String parseJson(String json) throws JSONException {
        JSONObject obj = new JSONObject(json);
        JSONArray datas = obj.getJSONArray("data");

        JSONObject data = null;

        List<Person> list =new ArrayList<>();
        Person person = null;

        for (int i=0;i<datas.length();i++){
            data = datas.getJSONObject(i);

            String name = data.getString("name");
            int age = data.getInt("age");

            person = new Person(name,age);
            list.add(person);
        }

        for (int i = 0; i <list.size() ; i++) {
            person = list.get(i);
            System.out.print("name:"+ person.getName());
        }
        return null;
    }
}
