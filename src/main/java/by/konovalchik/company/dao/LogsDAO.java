package by.konovalchik.company.dao;
import by.konovalchik.company.entity.logXML.Log;
import java.util.List;

public interface LogsDAO {

    List<Log> getLogs();
    void clearLogs();
}
