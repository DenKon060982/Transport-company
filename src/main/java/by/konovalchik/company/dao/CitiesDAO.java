package by.konovalchik.company.dao;

import by.konovalchik.company.entity.cities.City;

import java.util.List;

public interface CitiesDAO {

    List<City> getCities();
    List<String> getCitiesNames();
    City searchCity(String name_city);
    void addCity(City city);
    void deleteCity(int id_city);
    void updateCity(City city);
}
