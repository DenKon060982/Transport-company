package by.konovalchik.company.application.userActions;

import by.konovalchik.company.application.utils.Input;
import by.konovalchik.company.controllers.UsersController;
import by.konovalchik.company.controllers.UsersControllerImp;

public class AuthorizationUser {
     private  UsersController controllerUsers = new UsersControllerImp();

    public int apply() {
        int idRole = 0;
        do {
            String login = Input.getString("Введите логин: ");
            String password = Input.getString("Введите пароль: ");
            idRole = controllerUsers.searchUser(login, password);
            if(idRole == 0){
                System.out.println("Пользователя с такими атрибутами не существует!!");
            }
        }while(idRole == 0);

        return idRole;



    }
}
