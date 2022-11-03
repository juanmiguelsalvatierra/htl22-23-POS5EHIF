import java.util.Random;

public class Wetterstation implements IAnfrage {
    public String name;
    public EWolke bgrad;
    Random rnd = new Random();

    public Wetterstation(String name){
        this.name = name;
    }

    @Override
    public void Wetter() {

    }
}
