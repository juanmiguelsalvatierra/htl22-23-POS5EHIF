import java.util.Random;

public class Person implements Runnable{
    public String name;
    public IBuchung ib;
    public static Random rnd = new Random();
    public Person(String name, IBuchung ib){
        this.name = name;
        this.ib = ib;
    }

    @Override
    public void run() {
        while(true){
            boolean abheben = rnd.nextBoolean();
            int wert = 0;
            if(abheben){
                wert = rnd.nextInt(-1000);
            }
            else {
                wert = rnd.nextInt(1000);
            }
            ib.Buchen(wert);
            try {
                Thread.sleep((long)rnd.nextInt(6) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
