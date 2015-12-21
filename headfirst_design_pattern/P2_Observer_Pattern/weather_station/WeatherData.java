/**
* @package weather_station
* @author ZS@ZJU
* @version V1.0
*/
package weather_station;

import java.util.Observable;

/**
* @className WeatherData
* @description TODO
* @author ZS@ZJU
* @date Dec 11, 2015 11:13:25 AM
*/
public class WeatherData extends Observable {
    // fields
    private float temperature = 0;
    private float humidity = 0;
    private float pressure = 0;

    // constructor
    public WeatherData() {

    }

    public void measurementsChanged() {
        setChanged();   //标记状态已改变的事实
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
    
    

}
