package by.konovalchik.company.dao;
import by.konovalchik.company.connections.MysqlConnection;
import by.konovalchik.company.entity.cities.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitiesMysqlDAO implements CitiesDAO{

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
        }catch(SQLException e) {
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
            if(resultSet.next()){
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
        try(Connection connection = MysqlConnection.getConnection()) {
            String sql = "INSERT INTO cities VALUES (NULL, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, city.getName());
            statement.setDouble(2, city.getLatitude());
            statement.setDouble(3, city.getLongitude());
            statement.setBoolean(4, city.isAirport());
            statement.setBoolean(5, city.isSeaport());
            statement.execute();
        }catch(SQLException e ) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteCity(int id_city) {
        try(Connection connection = MysqlConnection.getConnection()){
            String sql = "DELETE FROM cities WHERE name_city = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_city);
            statement.execute();
        }catch(SQLException e) {
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

        }catch(SQLException e) {
           e.printStackTrace();
        }
    }
}
