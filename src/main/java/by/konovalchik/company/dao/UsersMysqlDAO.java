package by.konovalchik.company.dao;

import by.konovalchik.company.connections.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMysqlDAO implements UsersDAO {

    @Override
    public int searchUser(String login, String password) {
        int idRole = 0;
        try(Connection connect = MysqlConnection.getConnection()){
            String sql = "SELECT u.id_role  FROM users u WHERE u.login = ? AND u.password = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,login);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                idRole = resultSet.getInt("id_role");
            }
            return idRole;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
