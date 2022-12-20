import java.util.LinkedList;
import java.util.Random;

public class Konto implements IBuchung{
    public String name;
    public int stand;
    public static Random rnd = new Random();
    public LinkedList<Person> ber = new LinkedList<>();

    public Konto(String name, int stand){
        this.name = name;
        this.stand = stand;

        ber.add(new Person("Matthias", this));
    }

    @Override
    public void Buchen(int wert) {
        this.stand = this.stand + wert;
    }
}
