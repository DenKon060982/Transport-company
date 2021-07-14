package by.konovalchik.company.controllers;

import by.konovalchik.company.entity.users.User;

public interface UsersController {

    int searchUser(String login, String password);

    void addUser(User user);

    void addUserAdmin(User user);

}
