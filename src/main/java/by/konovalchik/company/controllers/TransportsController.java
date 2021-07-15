package by.konovalchik.company.controllers;
import by.konovalchik.company.entity.transports.Transport;
import by.konovalchik.company.exceptions.DuplicateTransportException;
import java.util.List;

public interface TransportsController {

    List<Transport> searchTransport(boolean airport, boolean seaport, int capacity, int carrying);

    List<Transport> getTransports();
    void addTransport(Transport transport) throws DuplicateTransportException;
    void deleteTransport(int id);
    void updateTransport(Transport transport);


}
