package by.konovalchik.company.entity.transports;

public class TransportType {
    private int id;
    private String name;

    public TransportType(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public TransportType(){}

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

    @Override
    public String toString() {
        return  "id = " + id +
                " | name = " + name;
    }
}
