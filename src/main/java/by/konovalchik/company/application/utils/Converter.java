package by.konovalchik.company.application.utils;

import by.konovalchik.company.connections.MysqlConnection;
import by.konovalchik.company.controllers.LogsController;
import by.konovalchik.company.controllers.LogsControllerImp;
import by.konovalchik.company.entity.logXML.Log;
import by.konovalchik.company.entity.logXML.LogWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Converter implements Runnable {

  public static void toXML(){
      LogsController controller = new LogsControllerImp();
      LogWrapper logWrapper = new LogWrapper(controller.getLogs());

        try{
            JAXBContext context = JAXBContext.newInstance(LogWrapper.class, Log.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(logWrapper, new File("transports_log.xml"));
        } catch(JAXBException e) {
            e.printStackTrace();
        }
  }

  public static void toSQL(String text){
      try(Connection connection = MysqlConnection.getConnection()){
          String sql = "INSERT INTO transports_logs VALUES (NULL, ?)";
          PreparedStatement statement = connection.prepareStatement(sql);
          statement.setString(1, text);
          statement.execute();
      } catch(SQLException e) {
          e.printStackTrace();
      }
  }

  public static void clear(){
      LogsController controller = new LogsControllerImp();
      controller.clearLogs();
  }

    @Override
    public void run() {
        toXML();
    }
}
