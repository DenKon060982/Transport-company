package by.konovalchik.company.application.components.actions.city;

import by.konovalchik.company.application.components.actions.Action;
import by.konovalchik.company.application.utils.Input;
import by.konovalchik.company.entity.City;

public class UpdateCityAction extends BaseCityAction implements Action {

    @Override
    public void apply() {
        int id = Input.getInt("Введите id города");
        City city = createCity();
        city.setId(id);
        controller.updateCity(city);
    }
}
