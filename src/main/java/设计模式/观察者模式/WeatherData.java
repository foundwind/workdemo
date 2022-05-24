package 设计模式.观察者模式;

import java.util.Observable;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2022/5/24
 */
public class WeatherData extends Observable {

    private String temp;

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(String temp) {
        setTemp(temp);
        measurementsChanged();
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
