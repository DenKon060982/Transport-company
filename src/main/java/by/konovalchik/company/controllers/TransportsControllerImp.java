package by.konovalchik.company.controllers;

import by.konovalchik.company.dao.TransportsDAO;
import by.konovalchik.company.dao.TransportsMysqlDAO;
import by.konovalchik.company.entity.transports.Transport;
import by.konovalchik.company.exceptions.DuplicateTransportException;

import java.util.List;

public class TransportsControllerImp implements TransportsController {
   private TransportsDAO daoTrans = new TransportsMysqlDAO();


    @Override
    public List<Transport> searchTransport(boolean airport, boolean seaport, int capacity, int carrying){
        return daoTrans.searchTransport(airport, seaport, capacity, carrying);
    }

    @Override
    public List<Transport> getTransports() {
        return daoTrans.getTransports();
    }

    @Override
    public void addTransport(Transport transport) throws DuplicateTransportException {
        if(daoTrans.getTransports().contains(transport)){
            throw new DuplicateTransportException();
        }
        daoTrans.addTransport(transport);
    }

    @Override
    public void deleteTransport(int id) {
        daoTrans.deleteTransport(id);
    }

    @Override
    public void updateTransport(Transport transport) {
        daoTrans.updateTransport(transport);
    }

}
