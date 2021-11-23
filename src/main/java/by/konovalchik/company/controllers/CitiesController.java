package by.konovalchik.company.controllers;
import by.konovalchik.company.entity.cities.City;
import by.konovalchik.company.exceptions.DuplicateCityException;
import java.util.List;

public interface CitiesController {

    List<City> getCities();
    List<String> getCitiesNames();
    City searchCity(String name_city);
    void addCity(City city) throws DuplicateCityException;
    void deleteCity(int id_city);
    void updateCity(City city);
}
