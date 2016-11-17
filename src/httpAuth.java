import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wthered on 17/11/2016 4:03 μμ
 * The Project name is mmo.
 */
@SuppressWarnings("ALL")
class httpAuth {

    boolean send(String user, String pass) {
        System.out.println("httpAuth.auth username " + user);
        System.out.println("httpAuth.auth password " + pass);
        boolean success = false;
        try {
            success = this.sendGet() == 200;
            JsonRead jr = new JsonRead();
            jr.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    private int sendGet() throws Exception {
        String query = "http://api.openweathermap.org/data/2.5/weather?q=naxos&appid=e5ddf07b3fcdd1e7febf01551aba84d0";
        URL url = new URL(query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:49.0) Gecko/20100101 Firefox/49.0");

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code is " + responseCode);

        if (responseCode == 200) {
            String response = getResponse(connection);
            System.out.println("Response = " + response);
        }
        return responseCode;
    }

    private String getResponse(HttpURLConnection connection) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            return response.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Line 41 Exception caught");
        }
        return "";
    }
}