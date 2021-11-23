package by.konovalchik.company.dao;

import by.konovalchik.company.entity.transports.Transport;

import java.util.List;

public interface TransportsDAO {

    List<Transport> searchTransport(boolean airport, boolean seaport, int capacity, int carrying);

    List<Transport> getTransports();
    void addTransport(Transport transport);
    void deleteTransport(int id);
    void updateTransport(Transport transport);

}
