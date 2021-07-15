package by.konovalchik.company.application.components.actions.transport;
import by.konovalchik.company.application.components.actions.Action;
import by.konovalchik.company.application.utils.Input;
import by.konovalchik.company.entity.transports.Transport;

public class UpdateTransportAction extends BaseTransportAction implements Action {

    @Override
    public void apply() {
        int id = Input.getInt("Введите id транспорта");
        Transport transport = createTransport();
        transport.setId(id);
        controller.updateTransport(transport);
    }
}
