package by.konovalchik.company.application.components.actions.transport;
import by.konovalchik.company.application.components.actions.Action;
public class ShowTransportsAction extends BaseTransportAction implements Action {

    @Override
    public void apply() {
        controller.getTransports().forEach(System.out::println);
    }
}
