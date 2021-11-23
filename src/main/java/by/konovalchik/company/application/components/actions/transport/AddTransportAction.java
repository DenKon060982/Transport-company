package by.konovalchik.company.application.components.actions.transport;
import by.konovalchik.company.application.components.actions.Action;
import by.konovalchik.company.entity.transports.Transport;
import by.konovalchik.company.exceptions.DuplicateTransportException;

public class AddTransportAction extends BaseTransportAction implements Action {

    @Override
    public void apply() {
        Transport transport = createTransport();
        try {
            controller.addTransport(transport);
        }catch(DuplicateTransportException e){
            System.out.println(e.getMessage());
        }
    }
}
