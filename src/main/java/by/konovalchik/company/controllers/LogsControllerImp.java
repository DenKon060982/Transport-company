package by.konovalchik.company.controllers;

import by.konovalchik.company.dao.CompanyMysqlDAO;
import by.konovalchik.company.dao.LogsDAO;
import by.konovalchik.company.entity.logXML.Log;

import java.util.List;

public class LogsControllerImp implements LogsController {
   LogsDAO daoLogs = new CompanyMysqlDAO();


    @Override
    public List<Log> getLogs() {
        return daoLogs.getLogs();
    }

    @Override
    public void clearLogs() {
        daoLogs.clearLogs();
    }
}
