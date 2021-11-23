package by.konovalchik.company.application.components;
import by.konovalchik.company.application.components.actionsAuthorization.ActionAuthorization;

public class ButtonA {
    private String name;
    private ActionAuthorization actionAuthorization;

    public ButtonA(String name, ActionAuthorization actionAuthorization) {
        this.name = name;
        this.actionAuthorization = actionAuthorization;
    }

    public ButtonA() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActionAuthorization getActionAuthorization() {
        return actionAuthorization;
    }

    public void setActionAuthorization(ActionAuthorization actionAuthorization) {
        this.actionAuthorization = actionAuthorization;
    }

    public int click(){
       return actionAuthorization.apply();
    }
}
