import java.util.Random;

public class Person{
    public String name;
    public IBuchung ib;
    public static Random rnd = new Random();
    public Person(String name, IBuchung ib){
        this.name = name;
        this.ib = ib;
    }

    /*@Override
    public void run() {
        int wert = rnd.nextInt();
        ib.Buchen()
    }*/
}
