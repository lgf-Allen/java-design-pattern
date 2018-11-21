package com.allen.pattern.update;

import com.allen.pattern.update.observer.Observer;
import com.allen.pattern.update.subject.Subject;

/**
 * Created by meng on 2018/11/21.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    //温度
    private float temperature;
    //湿度
    private float humdity;

    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registryObserver(this);
    }

    @Override
    public void update(float temperature, float humdity, float pressure) {
        this.temperature = temperature;
        this.humdity = humdity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions : " + temperature + "F degrees and " + humdity + "% humdity");
    }
}
