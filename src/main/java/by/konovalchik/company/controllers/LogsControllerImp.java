package by.konovalchik.company.controllers;
import by.konovalchik.company.dao.LogsDAO;
import by.konovalchik.company.dao.LogsMysqlDAO;
import by.konovalchik.company.entity.logXML.Log;
import java.util.List;

public class LogsControllerImp implements LogsController {
   private LogsDAO daoLogs = new LogsMysqlDAO();

    @Override
    public List<Log> getLogs() {
        return daoLogs.getLogs();
    }

    @Override
    public void clearLogs() {
        daoLogs.clearLogs();
    }
}
