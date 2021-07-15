package by.konovalchik.company.application.components.actions.transport;

import by.konovalchik.company.application.utils.Input;
import by.konovalchik.company.controllers.TransportsController;
import by.konovalchik.company.controllers.TransportsControllerImp;
import by.konovalchik.company.entity.transports.Transport;
import by.konovalchik.company.entity.transports.TransportType;
import static java.sql.Types.NULL;

public abstract class BaseTransportAction {
  protected TransportsController controller = new TransportsControllerImp();

    protected Transport createTransport(){
        String name = Input.getString("Введите название");
        int speed = Input.getInt("Введите скорость");
        int capacity = Input.getInt("Введите количество человек");
        int carrying = Input.getInt("Введите вес груза");
        int price = Input.getInt("Введите стоимость 1км");
        int id_type = Input.getInt("Введите id типа транспорта");
        String name_type = Input.getString("Введите название типа транспорта");
        return new Transport(NULL, name, speed,capacity,carrying, price, new TransportType(id_type, name_type));
    }
}
