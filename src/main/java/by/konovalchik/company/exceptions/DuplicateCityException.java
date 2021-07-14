package by.konovalchik.company.exceptions;

public class DuplicateCityException extends Exception{
    private int id;

    public DuplicateCityException(int id) {
        this.id = id;
    }


    @Override
    public String getMessage() {
        return String.format("Город с id = %d уже существует", id);
    }
}
