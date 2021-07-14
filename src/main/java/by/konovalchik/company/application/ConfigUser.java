package by.konovalchik.company.application;

import by.konovalchik.company.application.components.Button;
import by.konovalchik.company.application.components.actions.SearchTransportsAction;
import by.konovalchik.company.application.components.actions.StopApplicationAction;
import by.konovalchik.company.application.components.actions.city.ShowCitiesNamesAction;

import java.util.HashMap;
import java.util.Map;

public class ConfigUser {
    public static final Map<Integer, Button> BUTTONS = new HashMap<>();

    static {
        BUTTONS.put(1, new Button("Список городов", new ShowCitiesNamesAction()));
        BUTTONS.put(2, new Button("Расчёт грузоперевозки", new SearchTransportsAction()));
        BUTTONS.put(3, new Button("Выход", new StopApplicationAction()));
    }

}
