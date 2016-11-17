import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by wthered on 17/11/2016 5:49 μμ
 * The Project name is mmo.
 */

class JsonRead {

    void read() {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("/home/wthered/json.txt"));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            System.out.println("JSON Name is " + name);

            long age = (Long) jsonObject.get("age");
            System.out.println("Your Age is " + age + " years old");

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("weather");
            for (Object MsgObj : msg) {
                JSONObject job = (JSONObject) MsgObj;
//                System.out.println("A Message could be " + MsgObj);
                System.out.println("Description is " + job.get("description"));
                System.out.println("Main Weather is" + job.get("main"));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}