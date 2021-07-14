package by.konovalchik.company.dao;

import by.konovalchik.company.connections.MysqlConnection;
import by.konovalchik.company.entity.City;
import by.konovalchik.company.entity.transports.Transport;
import by.konovalchik.company.entity.transports.TransportType;
import by.konovalchik.company.entity.logXML.Log;
import by.konovalchik.company.entity.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyMysqlDAO implements CompanyDAO, LogsDAO, UsersDAO{


    @Override
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = MysqlConnection.getConnection()){
            String sql = "SELECT * FROM cities";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                cities.add(new City(
                resultSet.getInt("id_city"),
                resultSet.getString("name_city"),
                resultSet.getDouble("latitude"),
                resultSet.getDouble("longitude"),
                resultSet.getBoolean("airport"),
                resultSet.getBoolean("seaport")
                ));
            }
            return cities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    @Override
    public List<String> getCitiesNames() {
        List<String> list = new ArrayList<>();
        try(Connection connection = MysqlConnection.getConnection()){
        String sql = "SELECT name_city FROM cities ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
              String name = resultSet.getString("name_city");
              list.add(name);
        }
        return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    @Override
    public City searchCity(String name_city) {
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "SELECT * FROM cities WHERE name_city = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString (1, name_city);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("id_city");
                String name= resultSet.getString("name_city");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");
                boolean airport = resultSet.getBoolean("airport");
                boolean seaport = resultSet.getBoolean("seaport");
                return new City(id,name, latitude, longitude, airport, seaport);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return new City();
    }


    @Override
    public void addCity(City city) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = "INSERT INTO cities VALUES (NULL, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, city.getName());
            statement.setDouble(2, city.getLatitude());
            statement.setDouble(3, city.getLongitude());
            statement.setBoolean(4, city.isAirport());
            statement.setBoolean(5, city.isSeaport());
            statement.execute();
        }catch (SQLException e ) {
            e.printStackTrace();
        }

    }


    @Override
    public void deleteCity(int id_city) {
        try (Connection connection = MysqlConnection.getConnection()){
            String sql = "DELETE FROM cities WHERE name_city = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_city);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateCity(City city) {
        int id = 0;
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "SELECT id_city FROM cities WHERE id_city = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt (1,city.getId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                id = resultSet.getInt("id_city");
            }
            if(id != 0) {
                String sqlUpdate = "UPDATE cities SET name_city = ?, latitude = ?, longitude = ?, airport = ?, seaport = ? WHERE id_city = ?";
                PreparedStatement statement1 = connection.prepareStatement(sqlUpdate);
                statement1.setString(1, city.getName());
                statement1.setDouble(2, city.getLatitude());
                statement1.setDouble(3, city.getLongitude());
                statement1.setBoolean(4, city.isAirport());
                statement1.setBoolean(5, city.isSeaport());
                statement1.setInt(6, id);
                statement1.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Transport> searchTransport(boolean airport, boolean seaport, int capacity, int carrying) {
        int a = 0;
        int s = 0;
        if (airport){a = 2;}
        if (seaport){s = 3;}
        List<Transport> transports = new ArrayList<>();
        try(Connection connection = MysqlConnection.getConnection()) {
            String sql = "SELECT t.id_trans, t.name, t.speed, t.capacity, t.carrying, t.price_km, tp.* FROM company.transports_list t LEFT JOIN company.transports_type tp ON t.id_category = tp.id_type WHERE tp.id_type IN (1, ?, ?) AND (t.capacity >= ? AND t.carrying >= ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, a);
            statement.setInt(2, s);
            statement.setInt(3, capacity);
            statement.setInt(4, carrying);
            ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            transports.add(new Transport(
                    resultSet.getInt("id_trans"),
                    resultSet.getString("name"),
                    resultSet.getInt("speed"),
                    resultSet.getInt("capacity"),
                    resultSet.getInt("carrying"),
                    resultSet.getInt("price_km"),
                    new TransportType(resultSet.getInt("id_type"), resultSet.getString("name_type"))
            ));
        }
        return transports;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    @Override
    public List<Transport> getTransports() {
        List<Transport> transports =  new ArrayList<>();
        try (Connection connection = MysqlConnection.getConnection()){
            String sql = "SELECT t.id_trans, t.name, t.speed, t.capacity, t.carrying, t.price_km, tp.* FROM company.transports_list t LEFT JOIN company.transports_type tp ON t.id_category = tp.id_type";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                transports.add(new Transport(
                        resultSet.getInt("id_trans"),
                        resultSet.getString("name"),
                        resultSet.getInt("speed"),
                        resultSet.getInt("capacity"),
                        resultSet.getInt("carrying"),
                        resultSet.getInt("price_km"),
                        new TransportType(resultSet.getInt("id_type"), resultSet.getString("name_type"))
                ));
            }
            return transports;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void addTransport(Transport transport) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = "INSERT INTO transports_list VALUES (NULL, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, transport.getName());
            statement.setInt(2, transport.getSpeed());
            statement.setInt(3, transport.getCapacity());
            statement.setInt(4, transport.getCarrying());
            statement.setInt(5, transport.getPrice());
            statement.setInt(6, transport.getTransportType().getId());
            statement.execute();
        }catch (SQLException e ) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTransport(int id) {
        try (Connection connection = MysqlConnection.getConnection()){
            String sql = "DELETE FROM transports_list WHERE id_trans = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTransport(Transport transport) {
        int id = 0;
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "SELECT id_trans FROM transports_list WHERE id_trans = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt (1,transport.getId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                 id = resultSet.getInt("id_trans");
            }
            if(id != 0) {
                String sqlUpdate = "UPDATE transports_list SET name = ?, speed = ?, capacity = ?, carrying = ?, price_km = ?, id_category = ? WHERE id_trans = ?";
                PreparedStatement statement1 = connection.prepareStatement(sqlUpdate);
                statement1.setString(1, transport.getName());
                statement1.setInt(2, transport.getSpeed());
                statement1.setInt(3, transport.getCapacity());
                statement1.setInt(4, transport.getCarrying());
                statement1.setInt(5, transport.getPrice());
                statement1.setInt(6, transport.getTransportType().getId());
                statement1.setInt(7, transport.getId());
                statement1.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Log> getLogs() {
        List<Log> logs = new ArrayList<>();
        try (Connection connect = MysqlConnection.getConnection()){
            String sql = "SELECT * FROM transports_logs";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                logs.add( new Log(
                        resultSet.getInt("id_log"),
                        resultSet.getString("text_log")));
            }
            return logs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void clearLogs() {
        try (Connection connect = MysqlConnection.getConnection()){
            String sql = "TRUNCATE TABLE transports_logs";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int searchUser(String login, String password) {
        int idRole = 0;
        try ( Connection connect = MysqlConnection.getConnection()){
            String sql = "SELECT u.id_role  FROM users u WHERE u.login = ? AND u.password = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,login);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                idRole = resultSet.getInt("id_role");
            }
            return idRole;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public void addUser(User user) {

    }

    @Override
    public void addUserAdmin(User user) {

    }
}
