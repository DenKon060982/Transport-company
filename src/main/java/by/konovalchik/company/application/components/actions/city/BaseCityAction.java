package by.konovalchik.company.application.components.actions.city;
import by.konovalchik.company.application.utils.Input;
import by.konovalchik.company.controllers.CitiesController;
import by.konovalchik.company.controllers.CitiesControllerImp;
import by.konovalchik.company.entity.cities.City;
import static java.sql.Types.NULL;

public abstract class BaseCityAction {
  protected CitiesController controller = new CitiesControllerImp();

    protected City createCity(){
        String name = Input.getString("Введите название города");
        double latitude = Input.getDouble("Введите широту");
        double longitude = Input.getDouble("Введите долготу");
        boolean airport = Input.getBoolean("Введите наличие аэропорта: true или false");
        boolean seaport = Input.getBoolean("Введите наличие морского порта: true или false");
        return new City(NULL, name, latitude, longitude, airport, seaport);
    }

}
