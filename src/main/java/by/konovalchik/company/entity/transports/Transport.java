package by.konovalchik.company.entity.transports;

import java.util.Objects;

public class Transport {
    private int id;
    private String name;
    private int speed;
    private int capacity;
    private int carrying;
    private int price;
    private TransportType transportType;

    public Transport(int id, String name, int speed, int capacity, int carrying, int price, TransportType transportType) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.capacity = capacity;
        this.carrying = carrying;
        this.price = price;
        this.transportType = transportType;
    }

    public Transport(int id) {
        this.id = id;
    }

    public Transport(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return id == transport.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return  " | id=" + id +
                " | name=" + name +
                " | speed=" + speed +
                " | capacity=" + capacity +
                " | carrying=" + carrying +
                " | price=" + price +
                " | transportType: " + transportType;
    }
}
