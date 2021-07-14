package by.konovalchik.company.application.components.actions.city;

import by.konovalchik.company.application.components.actions.Action;
import by.konovalchik.company.entity.City;
import by.konovalchik.company.exceptions.DuplicateCityException;


public class AddCityAction extends BaseCityAction implements Action {

    @Override
    public void apply() {
        City city = createCity();
        try {
            controller.addCity(city);
        }catch (DuplicateCityException e){
            System.out.println(e.getMessage());
        }
    }
}
