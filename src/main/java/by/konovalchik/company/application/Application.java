package by.konovalchik.company.application;
import by.konovalchik.company.application.components.Button;
import by.konovalchik.company.application.components.ButtonA;
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
        int idRole = 0;
        while(idRole == 0) {
            ButtonA buttonA = selectButtonA();
            try {
            idRole = buttonA.click();
            } catch(StopApplicationException e) {
                break;
            }
        }

        if(idRole != 0) {
            while (true) {
                Button button = selectButton(idRole);
                try {
                    button.click();
                    Thread logThread = new Thread(new Converter(), "Поток записи лога в xml");
                    logThread.start();
                    logThread.join();
                } catch(StopApplicationException | InterruptedException e) {
                    break;
                }
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------
    private Button selectButton(int idRole){

        showMenu(idRole);

        if(idRole == 1){
            int key = Input.getInt();
            if(ConfigAdmin.BUTTONS.containsKey(key)){
                return ConfigAdmin.BUTTONS.get(key);
            }
            System.out.println("Нет такого действия!!! Повторите ввод");
            return selectButton(idRole);
        }

        if(idRole == 2){
            int key = Input.getInt();
            if(ConfigUser.BUTTONS.containsKey(key)){
                return ConfigUser.BUTTONS.get(key);
            }
            System.out.println("Нет такого действия!!! Повторите ввод");
            return selectButton(idRole);
        }
        return selectButton(idRole);
    }


    private void showMenu(int idRole){
        switch(idRole){
            case 1:
                System.out.println("Выберите действие ");
                for(Map.Entry<Integer, Button> item: ConfigAdmin.BUTTONS.entrySet()) {
                    System.out.println(item.getKey() + " - " + item.getValue().getName());
                }
                break;
            case 2:
                System.out.println("Выберите действие ");
                for(Map.Entry<Integer, Button> item: ConfigUser.BUTTONS.entrySet()) {
                    System.out.println(item.getKey() + " - " + item.getValue().getName());
                }
                break;
            default:
                break;
        }
    }

    private void showMenuAuthorization(){
        for(Map.Entry<Integer, ButtonA> item: ConfigAuthorization.BUTTONS.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue().getName());
        }
    }

    private ButtonA selectButtonA(){
        showMenuAuthorization();
        int key = Input.getInt();

        if(ConfigAuthorization.BUTTONS.containsKey(key)){
            return ConfigAuthorization.BUTTONS.get(key);
        }
        System.out.println("Нет такого действия!!! Повторите ввод");
        return selectButtonA();
    }
}
