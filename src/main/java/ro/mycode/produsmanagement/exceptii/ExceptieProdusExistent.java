package ro.mycode.produsmanagement.exceptii;

public class ExceptieProdusExistent extends RuntimeException{

    public ExceptieProdusExistent() {
        super("Acest produs exista deja in baza de date!!!");
    }
}
