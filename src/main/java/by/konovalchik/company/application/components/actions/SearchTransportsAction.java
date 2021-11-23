package by.konovalchik.company.application.components.actions;
import by.konovalchik.company.application.utils.Calculate;
import by.konovalchik.company.application.utils.Input;
import by.konovalchik.company.application.utils.Converter;
import by.konovalchik.company.controllers.CitiesController;
import by.konovalchik.company.controllers.CitiesControllerImp;
import by.konovalchik.company.controllers.TransportsController;
import by.konovalchik.company.controllers.TransportsControllerImp;
import by.konovalchik.company.dao.comparators.ComparatorTransportPrice;
import by.konovalchik.company.dao.comparators.ComparatorTransportSpeed;
import by.konovalchik.company.entity.cities.City;
import by.konovalchik.company.entity.transports.Transport;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchTransportsAction implements Action  {
    private TransportsController controllerT = new TransportsControllerImp();
    private CitiesController  controllerC = new CitiesControllerImp();

    public void apply(){
        List<City> cities = new ArrayList<>();
        double dist;
        City city2;
        City city4;

        do {
            String city1 = Input.getString("Введите город отправления: ");
            city2 = controllerC.searchCity(city1);
            if(city2.getId() == 0){ System.out.println("ОШИБКА!! Неверный ввод!");}
        } while(city2.getId() == 0);
        cities.add(city2);

        do {
            String city3 = Input.getString("Введите город назначения: ");
            city4 = controllerC.searchCity(city3);
            if(city4.getId() == 0){ System.out.println("ОШИБКА!! Неверный ввод!");}
        } while(city4.getId() == 0);
        cities.add(city4);

        int capacity = Input.getInt("Введите кол-во человек: ");
        int carrying = Input.getInt("Введите вес груза: ");

        dist = Calculate.getDistance(cities.get(0).getLatitude(),cities.get(0).getLongitude(),cities.get(1).getLatitude(), cities.get(1).getLongitude());

        boolean airport = false;
        boolean seaport = false;
        if(cities.get(0).isAirport() && cities.get(1).isAirport()) {airport = true;}
        if(cities.get(0).isSeaport() && cities.get(1).isSeaport())  {seaport = true;}

        List<Transport> transports = controllerT.searchTransport(airport,seaport, capacity, carrying);

            if(!transports.isEmpty() ) {
                Comparator<Transport> compSpeed = new ComparatorTransportSpeed();
                Comparator<Transport> compPrice = new ComparatorTransportPrice();

                transports.sort(compSpeed);
                int count1 = (int)(dist) * transports.get(0).getPrice();
                double time1 = dist / transports.get(0).getSpeed();
                String text1 = String.format("'%s' - самый быстрый транспорт для доставки %d человек и %d кг груза маршрутом %s - %s.\nВремя в пути %.2f ч. Стоимость %d $. ",
                        transports.get(0).getName(), capacity, carrying, cities.get(0).getName(), cities.get(1).getName(), time1, count1);

                transports.sort(compPrice);
                int count2 = (int)(dist) * transports.get(0).getPrice();
                double time2 = dist/transports.get(0).getSpeed();
                String text2 = String.format("'%s' - самый дешёвый транспорт для доставки %d человек и %d кг груза маршрутом %s - %s.\nВремя в пути %.2f ч. Стоимость %d $. ",
                        transports.get(0).getName(), capacity, carrying, cities.get(0).getName(), cities.get(1).getName(), time2, count2);

                String text = text1.concat(text2);

                Converter.toSQL(text);

                System.out.println("=============================================================================================================");
                System.out.println(text1);
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                System.out.println(text2);
                System.out.println("=============================================================================================================");
            } else System.out.println("Нет транспорта, удовлетворяющему вашему запросу!!");
    }

}
