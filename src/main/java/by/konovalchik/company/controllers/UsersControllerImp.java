package by.konovalchik.company.controllers;
import by.konovalchik.company.dao.UsersDAO;
import by.konovalchik.company.dao.UsersMysqlDAO;
public class UsersControllerImp implements UsersController{
    private UsersDAO daoUsers = new UsersMysqlDAO();

    @Override
    public int searchUser(String login, String password) {
        return daoUsers.searchUser(login, password);
    }
}
