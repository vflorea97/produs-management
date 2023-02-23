package ro.mycode.produsmanagement.exceptii;

public class ExceptieProdusEmptyDB extends RuntimeException{

    public ExceptieProdusEmptyDB() {
        super("Baza de date este goala!!!");
    }
}
