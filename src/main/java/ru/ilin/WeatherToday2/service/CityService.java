package ru.ilin.WeatherToday2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ilin.WeatherToday2.model.City;
import ru.ilin.WeatherToday2.repository.CityRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CityService {
    CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Optional<City> getCityByName(String name) {
       return cityRepository.findByCity(name);
    }

    @Transactional
    public void save(City city) {
        cityRepository.save(city);
    }
}
