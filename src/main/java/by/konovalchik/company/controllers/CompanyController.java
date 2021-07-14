package by.konovalchik.company.controllers;

import by.konovalchik.company.entity.City;
import by.konovalchik.company.entity.transports.Transport;
import by.konovalchik.company.exceptions.DuplicateCityException;
import by.konovalchik.company.exceptions.DuplicateTransportException;

import java.util.List;

public interface CompanyController {

    List<City> getCities();
    List<String> getCitiesNames();
    City searchCity(String name_city);
    void addCity(City city) throws DuplicateCityException;
    void deleteCity(int id_city);
    void updateCity(City city);

    List<Transport> searchTransport(boolean airport, boolean seaport, int capacity, int carrying);

    List<Transport> getTransports();
    void addTransport(Transport transport) throws DuplicateTransportException;
    void deleteTransport(int id);
    void updateTransport(Transport transport);


}
