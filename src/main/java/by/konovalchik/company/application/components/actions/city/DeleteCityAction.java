package by.konovalchik.company.application.components.actions.city;

import by.konovalchik.company.application.components.actions.Action;
import by.konovalchik.company.application.utils.Input;

public class DeleteCityAction extends BaseCityAction implements Action {

    @Override
    public void apply() {
       int id = Input.getInt("Введите id города");
       controller.deleteCity(id);
    }
}
