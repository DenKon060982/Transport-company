package by.konovalchik.company.exceptions;

public class DuplicateTransportException extends Exception {
    private int id;

    public DuplicateTransportException(int id) {
        this.id = id;
    }

    public DuplicateTransportException() {
    }

    @Override
    public String getMessage() {
        return String.format("Транспорт с id = %d уже существует", id);
    }
}
