package ru.ilin.WeatherToday2.model;


import jakarta.persistence.*;


@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    public City() {
    }

    public City(String city) {
        this.city = city;
    }
}
