package ro.mycode.produsmanagement.exceptii;

public class ExceptieProdusNeexistent extends RuntimeException{

    public ExceptieProdusNeexistent() {
        super("Acest produs nu exista in baza de date!!!");
    }
}
