/**
* @package weather_station
* @author ZS@ZJU
* @version V1.0
*/
package weather_station;

/**
* @className Test
* @description TODO
* @author ZS@ZJU
* @date Dec 11, 2015 4:31:31 PM
*/
public class Test {
    public static void main(String[] args) {
        WeatherData data = new WeatherData();
        CurrentConditionDisplay cc_dashboard = new CurrentConditionDisplay(data);

        data.setMeasurements(80, 65, 30.4f);
        data.setMeasurements(82, 70, 29.2f);
        data.setMeasurements(78, 90, 29.2f);

        // do something with cc_dashboard
        System.out.println(cc_dashboard);

    }
}
