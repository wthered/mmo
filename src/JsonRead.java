import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

			JSONObject jsonObject = (JSONObject) parser.parse(http.sendGet());

			JSONObject baseSystem = (JSONObject) jsonObject.get("sys");
			JSONObject system = (JSONObject) parser.parse(baseSystem.toString());

			long sunRise = (long) system.get("sunrise");
			long sunDown = (long) system.get("sunset");

			System.out.println("JsonRead.read Sun rise at " + sunRise + " or " + this.unix2time(sunRise));
			System.out.println("JsonRead.read Sun sets at " + sunDown + " or " + this.unix2time(sunDown));

//			long age = (Long) jsonObject.get("age");
//			System.out.println("Your Age is " + age + " years old");

			// loop array
			JSONArray msg = (JSONArray) jsonObject.get("weather");
			for (Object MsgObj : msg) {
				JSONObject job = (JSONObject) MsgObj;
//				System.out.println("A Message could be " + MsgObj.toString());
				System.out.println("Weather Prediction\tfor Naxos is " + job.get("description"));
				System.out.println("Weather Condition\tfor Naxos now " + job.get("main"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private String unix2time(long timestamp) {
		Date date = new Date(timestamp*1000L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/Athens"));
		return sdf.format(date);
	}
}