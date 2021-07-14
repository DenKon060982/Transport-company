package by.konovalchik.company.dao;

import by.konovalchik.company.entity.transports.Transport;

import java.util.Comparator;

public class ComparatorTransportSpeed implements Comparator <Transport> {

    public int compare(Transport o1, Transport o2) {
        return o2.getSpeed() - o1.getSpeed();
    }
}
