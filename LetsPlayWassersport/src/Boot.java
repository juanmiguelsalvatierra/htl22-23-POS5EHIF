import java.util.Random;

public abstract class Boot implements Runnable, IWind{
    public int nr;
    public float speed;
    static Random rnd = new Random();
    public float distanzZumZiel = 200;
    public IFertig rennleitung;
    public boolean gekentert = false;
    public Boot(int nr, float speed, IFertig rennleitung){
        this.nr = nr;
        this.speed = speed;
        this.rennleitung = rennleitung;
    }

    public void run(){
        try {
            Thread.sleep(rnd.nextInt(2, 5) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Teilnehmer " + nr + " hat gestartet");

        while(distanzZumZiel > 0){
            if(gekentert){
                return;
            }
            distanzZumZiel = distanzZumZiel - speed / 10;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Teilnehmer " + nr + " hat das Ziel erreicht");
        rennleitung.finish(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "\nstartnummer ....... : " + nr +
                "\ngeschwindigkeit ... : " + speed + " m/s" +
                "\ndistanz zum Ziel .. : " + distanzZumZiel + " m" +
                "\n}\n";
    }
}
