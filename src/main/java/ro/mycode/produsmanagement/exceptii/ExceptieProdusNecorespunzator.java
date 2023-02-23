package ro.mycode.produsmanagement.exceptii;

public class ExceptieProdusNecorespunzator extends RuntimeException{

    public ExceptieProdusNecorespunzator() {
        super("Nici un produs nu corespunde cu cerintele date!!!");
    }
}
