package com.allen.pattern.update;

import com.allen.pattern.update.observer.Observer;
import com.allen.pattern.update.subject.Subject;

/**
 * Created by meng on 2018/11/21.
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    //温度
    private float temperature;
    //湿度
    private float humdity;
    //气压
    private float pressure;

    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registryObserver(this);
    }

    @Override
    public void update(float temperature, float humdity, float pressure) {
        this.temperature = temperature;
        this.humdity = humdity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {

    }
}
