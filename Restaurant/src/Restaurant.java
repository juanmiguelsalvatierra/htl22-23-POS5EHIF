import java.util.LinkedList;
import java.util.Random;

public class Restaurant {

    static Random rnd = new Random();
    public LinkedList<Kunde> kunden = new LinkedList<>();

    public Restaurant(){
        for (int i = 0; i < 20; i++){
            kunden.add(new Kunde("Kunde" + i));
        }
    }

    public void Go(){
        while (true) {
            for (Kunde item : kunden) {
                item.orderTime = rnd.nextInt(20, 41);
            }
            for (Kunde item : kunden){

            }
        }
    }
}
