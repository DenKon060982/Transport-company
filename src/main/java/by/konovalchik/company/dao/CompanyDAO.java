package by.konovalchik.company.dao;

import by.konovalchik.company.entity.City;
import by.konovalchik.company.entity.transports.Transport;

import java.util.List;

public interface CompanyDAO {

     List<City> getCities();
     List<String> getCitiesNames();
     City searchCity(String name_city);
     void addCity(City city);
     void deleteCity(int id_city);
     void updateCity(City city);

    List<Transport> searchTransport(boolean airport, boolean seaport, int capacity, int carrying);

    List<Transport> getTransports();
    void addTransport(Transport transport);
    void deleteTransport(int id);
    void updateTransport(Transport transport);





}
