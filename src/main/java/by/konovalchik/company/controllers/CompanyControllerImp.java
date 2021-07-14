package by.konovalchik.company.controllers;

import by.konovalchik.company.dao.CompanyDAO;
import by.konovalchik.company.dao.CompanyMysqlDAO;
import by.konovalchik.company.entity.City;
import by.konovalchik.company.entity.transports.Transport;
import by.konovalchik.company.exceptions.DuplicateCityException;
import by.konovalchik.company.exceptions.DuplicateTransportException;

import java.util.List;

public class CompanyControllerImp implements CompanyController {
    CompanyDAO dao = new CompanyMysqlDAO();


    @Override
    public List<City> getCities() {
        return dao.getCities();
    }

    @Override
    public List<String> getCitiesNames() {
        return dao.getCitiesNames();
    }

    @Override
    public City searchCity(String name_city) {
        return dao.searchCity(name_city);
    }

    @Override
    public void addCity(City city) throws DuplicateCityException {
        if (dao.getCities().contains(city)){
            throw new DuplicateCityException(city.getId());
        }
        dao.addCity(city);
    }

    @Override
    public void deleteCity(int id_city) {
        dao.deleteCity(id_city);
    }

    @Override
    public void updateCity(City city) {
        dao.updateCity(city);
    }


    @Override
    public List<Transport> searchTransport(boolean airport, boolean seaport, int capacity, int carrying){
        return dao.searchTransport(airport, seaport, capacity, carrying);
    }

    @Override
    public List<Transport> getTransports() {
        return dao.getTransports();
    }

    @Override
    public void addTransport(Transport transport) throws DuplicateTransportException {
        if(dao.getTransports().contains(transport)){
            throw new DuplicateTransportException();
        }
        dao.addTransport(transport);
    }

    @Override
    public void deleteTransport(int id) {
        dao.deleteTransport(id);
    }

    @Override
    public void updateTransport(Transport transport) {
        dao.updateTransport(transport);
    }


}
