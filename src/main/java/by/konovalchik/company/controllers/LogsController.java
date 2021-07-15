package by.konovalchik.company.controllers;
import by.konovalchik.company.entity.logXML.Log;
import java.util.List;

public interface LogsController {

    List<Log> getLogs();
    void clearLogs();
}
