import java.util.LinkedList;
import java.util.Random;

public class Sim {
    Random rnd = new Random();
    public LinkedList<Boot> teilnehmer = new LinkedList<>();

    public Sim(){
        for (int i = 0; i < 10; i++) {
            int temp = rnd.nextInt(100);
            float speed = (rnd.nextInt(14) + 27) / 10;
            if(temp <= 33){
                int segel = rnd.nextInt(2) + 1;
                teilnehmer.add(new Segelboot(i+1, speed, segel));
            } else {
                int laenge = rnd.nextInt(101) + 500;
                teilnehmer.add(new Kajak(i+1, speed, laenge));
            }
        }
    }
}
