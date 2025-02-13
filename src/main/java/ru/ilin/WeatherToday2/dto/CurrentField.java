package ru.ilin.WeatherToday2.dto;

public class CurrentField {
    public String observation_time;
    public String temperature;

    public String getObservation_time() {
        return observation_time;
    }

    public void setObservation_time(String observation_time) {
        this.observation_time = observation_time;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "время измерения температуры='" + observation_time + '\'' +
                ", температура='" + temperature + '\'';
    }
}
