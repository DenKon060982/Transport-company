package by.konovalchik.company.controllers;

import by.konovalchik.company.dao.CompanyMysqlDAO;
import by.konovalchik.company.dao.UsersDAO;
import by.konovalchik.company.entity.users.User;

public class UsersControllerImp implements UsersController{
    private UsersDAO daoUsers = new CompanyMysqlDAO();

    @Override
    public int searchUser(String login, String password) {
        return daoUsers.searchUser(login, password);
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void addUserAdmin(User user) {

    }
}
