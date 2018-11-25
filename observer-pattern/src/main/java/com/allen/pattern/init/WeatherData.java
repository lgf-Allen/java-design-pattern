package com.allen.pattern.init;


/**
 * Created by meng on 2018/11/14.
 */
public class WeatherData {

    //温度
    private float temperature;
    //湿度
    private float humdity;
    //气压
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumdity() {
        return humdity;
    }

    public float getPressure() {
        return pressure;
    }

    public void measurementsChanged(){
        float temperature = getTemperature();
        float humdity = getHumdity();
        float pressure = getPressure();
        //将数据分别展示到不同的展板
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
        currentConditionDisplay.update(temperature , humdity , pressure);

        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        statisticsDisplay.update(temperature , humdity , pressure);

        ForecastDisplay forecastDisplay = new ForecastDisplay();
        forecastDisplay.update(temperature , humdity , pressure);
    }
}
