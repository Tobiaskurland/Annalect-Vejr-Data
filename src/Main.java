import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {

        String root = "http://api.apixu.com/v1/history.json?key=72e2fcadea4343ffb10113630191608&";

        List<String> weatherData = new ArrayList<>();
        String header1 = "Date, Location, MaxTemp_c, MinTemp_c, Sunrise, Sunset, condition";

        weatherData.add(header1);


        List<String> cities = new ArrayList<>();
        cities.add("q=copenhagen&");
        cities.add("q=odense&");
        cities.add("q=aarhus&");

        List<String> dates = new ArrayList<>();
        dates.add("dt=2019-08-15");
        dates.add("dt=2019-08-14");
        dates.add("dt=2019-08-13");
        dates.add("dt=2019-08-12");
        dates.add("dt=2019-08-11");
        dates.add("dt=2019-08-10");
        dates.add("dt=2019-08-09");

        for (int i = 0; i<cities.size(); i++) {
            for (int j = 0; j<dates.size(); j++) {

                URL vejr = new URL(root + cities.get(i) + dates.get(j));
                String readLine = null;
                HttpURLConnection connection = (HttpURLConnection) vejr.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("forecast", "albcdef");
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    StringBuffer response = new StringBuffer();
                    while ((readLine = in.readLine()) != null) {
                        response.append(readLine);
                    }
                    in.close();


                    JSONObject myResponse = new JSONObject(response.toString());


                    //LOCATION
                    JSONObject location_object = new JSONObject(myResponse.getJSONObject("location").toString());


                    //FORECAST
                    JSONObject forecast_object = new JSONObject(myResponse.getJSONObject("forecast").toString());


                    //FORECASTDAY
                    JSONArray forecastday = forecast_object.getJSONArray("forecastday");


                    //INDEX 0
                    JSONObject obj_2 = forecastday.getJSONObject(0);


                    //DAY
                    JSONObject day = new JSONObject(obj_2.getJSONObject("day").toString());


                    //ASTRO
                    JSONObject astro = new JSONObject(obj_2.getJSONObject("astro").toString());


                    //CONDITION
                    JSONObject condition = new JSONObject(day.getJSONObject("condition").toString());

                    String date1 = obj_2.getString("date");
                    String name1 = location_object.getString("name");

                    double max1 = day.getDouble("maxtemp_c");
                    String numberAsString = String.valueOf(max1);

                    double min1 = day.getDouble("mintemp_c");
                    String numberAssString = String.valueOf(min1);

                    String sunrise1 = astro.getString("sunrise");
                    String sunset1 = astro.getString("sunset");
                    String condition1 = condition.getString("text");

                    String etEllerAndet = date1 + ", " + name1 + ", " + max1 + ", " + min1 + ", " + sunrise1 + ", " + sunset1 + ", " + condition1;

                    weatherData.add(etEllerAndet);


                } else {
                    System.out.println("failed");
                }
            }
        }

        for (int w=0; w<weatherData.size(); w++){
            System.out.println(weatherData.get(w));
        }

        saveData(weatherData);

    }

    public static void saveData(List<String> weatherData){

        try{

            FileWriter fileWriter = new FileWriter("vejrData.xlsx");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            for (int i = 0; i<weatherData.size(); i++) {
                printWriter.println(weatherData.get(i));
            }
            printWriter.flush();
            printWriter.close();

            JOptionPane.showMessageDialog(null,"Saved");

        }catch (Exception E){

            JOptionPane.showMessageDialog(null,"Not Saved");
        }

    }


}
