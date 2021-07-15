package by.konovalchik.company.application;

import by.konovalchik.company.application.components.ButtonA;
import by.konovalchik.company.application.components.actionsAuthorization.AuthorizationAction;
import by.konovalchik.company.application.components.actionsAuthorization.StopAuthorizationAction;

import java.util.HashMap;
import java.util.Map;

public class ConfigAuthorization {

    public static final Map<Integer, ButtonA> BUTTONS = new HashMap<>();

    static {
        BUTTONS.put(1, new ButtonA("Авторизация", new AuthorizationAction() ));
        BUTTONS.put(2, new ButtonA("Выход", new StopAuthorizationAction()));
    }
}
