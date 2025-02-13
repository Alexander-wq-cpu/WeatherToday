package ru.ilin.WeatherToday2.dto;

public class Location {
    String name;
    String country;
    String region;
    String localtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    @Override
    public String toString() {
        return "город='" + name + '\'' +
                ", страна='" + country + '\'' +
                ", регион='" + region + '\'' +
                ", текущее время='" + localtime + '\'';
    }
}
