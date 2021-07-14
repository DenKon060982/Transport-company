package by.konovalchik.company.application.components.actions;

import by.konovalchik.company.exceptions.StopApplicationException;

public class StopApplicationAction implements Action {

    @Override
    public void apply()  {
        throw new StopApplicationException();
    }
}
