package by.konovalchik.company.application.components.actionsAuthorization;

import by.konovalchik.company.exceptions.StopApplicationException;



public class StopAuthorizationAction  implements ActionAuthorization {

    @Override
    public int apply()  {
        throw new StopApplicationException();
    }
}
