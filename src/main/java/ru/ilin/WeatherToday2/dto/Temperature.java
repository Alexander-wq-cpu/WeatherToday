package ru.ilin.WeatherToday2.dto;

public class Temperature {
    Location location;
    CurrentField current;

    public CurrentField getCurrent() {
        return current;
    }

    public void setCurrent(CurrentField current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        if(current == null)
            return "Нет данных по этому городу";

        return current +"\n"+
                location;
    }
}
