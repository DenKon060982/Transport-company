package by.konovalchik.company.application.components.actions.transport;

import by.konovalchik.company.application.components.actions.Action;
import by.konovalchik.company.application.utils.Input;

public class DeleteTransportAction extends BaseTransportAction implements Action {

    @Override
    public void apply() {
        int id = Input.getInt("Введите id транспорта");
        controller.deleteTransport(id);
    }
}
