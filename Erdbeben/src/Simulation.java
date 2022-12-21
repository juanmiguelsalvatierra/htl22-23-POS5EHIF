import java.util.LinkedList;
import java.util.Random;

public class Simulation {

    public LinkedList<IErdbeben> gebList = new LinkedList<>();
    static Random rnd = new Random();
    public Simulation(){
        for (int i = 0; i < 5; i++) {
            gebList.add(new OeffGeb(rnd.nextInt(9)+1, rnd.nextInt(9)+1));
            gebList.add(new Wohn(rnd.nextInt(9)+1, rnd.nextInt(9)+1));
        }
        int ex = rnd.nextInt(9) + 1;
        int ey = rnd.nextInt(9) + 1;
        for(IErdbeben item : gebList){
            item.wackeln(ex, ey);
        }
    }
}
