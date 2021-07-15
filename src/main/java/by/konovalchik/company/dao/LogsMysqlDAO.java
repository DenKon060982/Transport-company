package by.konovalchik.company.dao;
import by.konovalchik.company.connections.MysqlConnection;
import by.konovalchik.company.entity.logXML.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogsMysqlDAO implements LogsDAO{

    @Override
    public List<Log> getLogs() {
        List<Log> logs = new ArrayList<>();
        try(Connection connect = MysqlConnection.getConnection()){
            String sql = "SELECT * FROM transports_logs";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                logs.add( new Log(
                        resultSet.getInt("id_log"),
                        resultSet.getString("text_log")));
            }
            return logs;
        }catch(SQLException e) {
           e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void clearLogs() {
        try(Connection connect = MysqlConnection.getConnection()){
            String sql = "TRUNCATE TABLE transports_logs";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
