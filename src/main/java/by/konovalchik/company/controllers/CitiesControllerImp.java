package by.konovalchik.company.controllers;
import by.konovalchik.company.dao.CitiesDAO;
import by.konovalchik.company.dao.CitiesMysqlDAO;
import by.konovalchik.company.entity.cities.City;
import by.konovalchik.company.exceptions.DuplicateCityException;
import java.util.List;

public class CitiesControllerImp implements CitiesController{
   private CitiesDAO daoCities = new CitiesMysqlDAO();

    @Override
    public List<City> getCities() {
        return daoCities.getCities();
    }

    @Override
    public List<String> getCitiesNames() {
        return daoCities.getCitiesNames();
    }

    @Override
    public City searchCity(String name_city) {
        return daoCities.searchCity(name_city);
    }

    @Override
    public void addCity(City city) throws DuplicateCityException {
        if(daoCities.getCities().contains(city)){
            throw new DuplicateCityException(city.getId());
        }
        daoCities.addCity(city);
    }

    @Override
    public void deleteCity(int id_city) {
        daoCities.deleteCity(id_city);
    }

    @Override
    public void updateCity(City city) {
        daoCities.updateCity(city);
    }


}
