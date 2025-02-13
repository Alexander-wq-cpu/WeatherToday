package ru.ilin.WeatherToday2.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ilin.WeatherToday2.model.City;
import ru.ilin.WeatherToday2.service.CityService;

import java.io.*;
@Component
public class RewriteDB {
    private CityService cityService;

    @Autowired
    public RewriteDB(CityService cityService) {
        this.cityService = cityService;
    }

    public void rewrite()throws IOException {
        BufferedReader bw  = new BufferedReader(new FileReader("C:\\Users\\Alexander\\Desktop\\cities.txt"));
        String line;
        while((line=bw.readLine())!=null){
            cityService.save(new City(line.toLowerCase()));
        }
    }

}
