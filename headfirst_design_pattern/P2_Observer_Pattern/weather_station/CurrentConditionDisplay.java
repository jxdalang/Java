/**
* @package weather_station
* @author ZS@ZJU
* @version V1.0
*/
package weather_station;

import java.util.Observable;
import java.util.Observer;

/**
* @className CurrentConditionDisplay
* @description TODO
* @author ZS@ZJU
* @date Dec 11, 2015 4:22:25 PM
*/
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionDisplay(Observable ob) {
        ob.addObserver(this);
    }

    @Override
    public void update(Observable ob, Object args) {
        if (ob instanceof WeatherData) {
            this.temperature = ((WeatherData) ob).getTemperature();
            this.humidity = ((WeatherData) ob).getHumidity();
            this.pressure = ((WeatherData) ob).getPressure();
            display();
        }
    }

    /*
     * (non-Javadoc) description TODO
     * 
     * @see weather_station.DisplayElement#display()
     */
    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println(
                "Current conditions: " + temperature + "F degrees and " + humidity + "% and" + pressure + "kPa.");
    }

}
