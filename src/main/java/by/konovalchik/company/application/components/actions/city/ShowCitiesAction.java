package by.konovalchik.company.application.components.actions.city;

import by.konovalchik.company.application.components.actions.Action;

public class ShowCitiesAction extends BaseCityAction implements Action {

    @Override
    public void apply() {
        controller.getCities().forEach(System.out::println);

    }
}
