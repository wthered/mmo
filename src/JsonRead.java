import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wthered on 17/11/2016 5:49 μμ
 * The Project name is mmo.
 */

class JsonRead {

	JsonRead() {
//		System.out.println("JsonRead Constructor");
	}

	void read() {

		String weather = null;
		httpAuth http = new httpAuth();
		JSONParser parser = new JSONParser();

		try {
//			Object obj = parser.parse(new FileReader("/home/wthered/json.txt"));
//			JSONObject jsonObject = (JSONObject) obj;

			JSONObject jsonObject = (JSONObject) parser.parse(http.sendGet());

			JSONObject baseSystem = (JSONObject) jsonObject.get("sys");
			JSONObject system = (JSONObject) parser.parse(baseSystem.toString());

			long sunRise = (long) system.get("sunrise");
			long sunDown = (long) system.get("sunset");

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date sunSett = new Date(sunDown);

			System.out.println("Sun rise at " + sunRise + " or " + dateFormat.format(sunRise));
			System.out.println("Sun sets at " + sunDown + " or " + dateFormat.format(sunSett));

//			long age = (Long) jsonObject.get("age");
//			System.out.println("Your Age is " + age + " years old");

			// loop array
			JSONArray msg = (JSONArray) jsonObject.get("weather");
			for (Object MsgObj : msg) {
				JSONObject job = (JSONObject) MsgObj;
//				System.out.println("A Message could be " + MsgObj.toString());
				System.out.println("Weather Prediction for Naxos is " + job.get("description"));
				System.out.println("Weather Contition for Naxos now " + job.get("main"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}