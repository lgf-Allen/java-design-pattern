package com.allen.pattern.update.main;

import com.allen.pattern.update.CurrentConditionsDisplay;
import com.allen.pattern.update.WeatherData;

/**
 * Created by meng on 2018/11/21.
 */
public class WeatherDataMain {


    public static void main(String[] args) {
        WeatherData data = new WeatherData();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay(data);

        data.setMeasurements(80 , 65 , 30.5f);
    }
}
