package com.allen.pattern.update;

import com.allen.pattern.update.observer.Observer;
import com.allen.pattern.update.subject.Subject;

import java.util.ArrayList;

/**
 * Created by meng on 2018/11/14.
 */
public class WeatherData implements Subject {

    //温度
    private float temperature;
    //湿度
    private float humdity;
    //气压
    private float pressure;

    private ArrayList<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumdity() {
        return humdity;
    }

    public float getPressure() {
        return pressure;
    }

    @Override
    public void registryObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObervers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature , humdity , pressure);
        }
    }

    public void measurementsChanged(){
        notifyObervers();
    }

    public void setMeasurements(float temperature , float humdity , float pressure ){
        this.temperature = temperature;
        this.humdity = humdity;
        this.pressure = pressure;
        measurementsChanged();
    }

}
