package by.konovalchik.company.application.components;
import by.konovalchik.company.application.components.actions.Action;

public class Button {
    private String name;
    private Action action;

    public Button(String name, Action action) {
        this.name = name;
        this.action = action;
    }


    Button(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void click(){
      action.apply();
    }
}
