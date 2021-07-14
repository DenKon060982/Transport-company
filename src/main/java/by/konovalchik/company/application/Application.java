package by.konovalchik.company.application;

import by.konovalchik.company.application.components.Button;
import by.konovalchik.company.application.userActions.AuthorizationUser;
import by.konovalchik.company.application.utils.Converter;
import by.konovalchik.company.application.utils.Input;
import by.konovalchik.company.exceptions.StopApplicationException;

import java.util.Map;

public class Application {

    public void start(){
        System.out.println("Добро пожаловать!");
        run();
        System.out.println("Всего хорошего!");
    }

    private void run() {
        AuthorizationUser authorizationUser =  new AuthorizationUser();
        int idRole = authorizationUser.apply();
        while (true){
            Button button = selectButton(idRole);
            try {
                button.click();
                Thread logThread = new Thread(new Converter(),"Поток записи лога в xml");
                logThread.start();
                logThread.join();
            } catch (StopApplicationException | InterruptedException e){
              break;
            }
        }
    }

    private Button selectButton(int idRole){

        showMenu(idRole);

        if (idRole == 1){
            int key = Input.getInt();
            if (ConfigAdmin.BUTTONS.containsKey(key)){
                return ConfigAdmin.BUTTONS.get(key);
            }
            System.out.println("Нет такого действия!!! Повторите ввод");
            return selectButton(idRole);
        }

        if (idRole == 2){
            int key = Input.getInt();
            if (ConfigUser.BUTTONS.containsKey(key)){
                return ConfigUser.BUTTONS.get(key);
            }
            System.out.println("Нет такого действия!!! Повторите ввод");
            return selectButton(idRole);
        }
        return selectButton(idRole);
    }

    private void showMenu(int idRole){
        System.out.println("Выберите действие");
        switch (idRole){
            case 1:
                for (Map.Entry<Integer, Button> item: ConfigAdmin.BUTTONS.entrySet()) {
                    System.out.println(item.getKey() + " - " + item.getValue().getName());
                }
                break;
            case 2:
                for (Map.Entry<Integer, Button> item: ConfigUser.BUTTONS.entrySet()) {
                    System.out.println(item.getKey() + " - " + item.getValue().getName());
                }
                break;
        }

    }

}
