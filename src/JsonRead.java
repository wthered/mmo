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

	JsonRead() {
		System.out.println("JsonRead Constructor");
	}

	void read() {

		String weather = null;
		httpAuth http = new httpAuth();
		JSONParser parser = new JSONParser();

		try {

//			Object obj = parser.parse(new FileReader("/home/wthered/json.txt"));

//			JSONObject jsonObject = (JSONObject) obj;
			JSONObject jsonObject = (JSONObject) parser.parse(http.sendGet());

			String base = (String) jsonObject.get("base");
			System.out.println("JSON Name is " + base);

//			long age = (Long) jsonObject.get("age");
//			System.out.println("Your Age is " + age + " years old");

			// loop array
			JSONArray msg = (JSONArray) jsonObject.get("weather");
			for (Object MsgObj : msg) {
				JSONObject job = (JSONObject) MsgObj;
				System.out.println("A Message could be " + MsgObj.toString());
				System.out.println("Description is " + job.get("description"));
				System.out.println("Main Weather is" + job.get("main"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}