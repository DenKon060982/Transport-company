package by.konovalchik.company.dao;

import by.konovalchik.company.entity.users.User;

public interface UsersDAO {

    int searchUser(String login, String password);

    void addUser(User user);

    void addUserAdmin(User user);
}
