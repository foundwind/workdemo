package 设计模式.观察者模式;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2022/5/24
 */
public class CurrentDisplay implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        WeatherData weatherData = (WeatherData) (o);
        System.out.println(weatherData.getTemp());
    }

    public static void main(String[] args) throws FileNotFoundException {
        WeatherData data = new WeatherData();
        data.addObserver(new CurrentDisplay());

        data.setMeasurements("13");
        data.setMeasurements("11");
        data.setMeasurements("9");
    }
}
