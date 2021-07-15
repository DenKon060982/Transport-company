package by.konovalchik.company.application;

import by.konovalchik.company.application.components.Button;
import by.konovalchik.company.application.components.actions.SearchTransportsAction;
import by.konovalchik.company.application.components.actions.StopApplicationAction;
import by.konovalchik.company.application.components.actions.city.*;
import by.konovalchik.company.application.components.actions.transport.AddTransportAction;
import by.konovalchik.company.application.components.actions.transport.DeleteTransportAction;
import by.konovalchik.company.application.components.actions.transport.ShowTransportsAction;
import by.konovalchik.company.application.components.actions.transport.UpdateTransportAction;

import java.util.HashMap;
import java.util.Map;

public class ConfigAdmin {
    public static final Map<Integer, Button> BUTTONS = new HashMap<>();

    static {
        BUTTONS.put(1, new Button("Список городов", new ShowCitiesNamesAction()));
        BUTTONS.put(2, new Button("Расчёт грузоперевозки", new SearchTransportsAction()));
        BUTTONS.put(3, new Button("Список городов (полный)", new ShowCitiesAction()));
        BUTTONS.put(4, new Button("Добавить город", new AddCityAction()));
        BUTTONS.put(5, new Button("Удалить город", new DeleteCityAction()));
        BUTTONS.put(6, new Button("Редактировать город", new UpdateCityAction()));
        BUTTONS.put(7, new Button("Список транспорта", new ShowTransportsAction()));
        BUTTONS.put(8, new Button("Добавить транспорт", new AddTransportAction()));
        BUTTONS.put(9, new Button("Удалить транспорт", new DeleteTransportAction()));
        BUTTONS.put(10, new Button("Редактировать транспорт", new UpdateTransportAction()));
        BUTTONS.put(11, new Button("Выход", new StopApplicationAction()));
    }

}
