package by.konovalchik.company.dao;

import by.konovalchik.company.connections.MysqlConnection;
import by.konovalchik.company.entity.transports.Transport;
import by.konovalchik.company.entity.transports.TransportType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportsMysqlDAO implements TransportsDAO {

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

        } catch(SQLException e) {
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

        }catch(SQLException e) {
           e.printStackTrace();
        }
    }
}
