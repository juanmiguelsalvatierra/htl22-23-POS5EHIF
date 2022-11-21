import java.util.Random;

public class Wetterstation implements IRequestData {
    public String stadt;
    public final IRespondData wz;
    private static Random rnd = new Random();

    public Wetterstation(String stadt, IRespondData wz){
        this.stadt = stadt;
        this.wz = wz;
    }

    @Override
    public void getData() {
        Wetterdaten wd = new Wetterdaten(stadt, rnd.nextInt(50) - 20, rnd.nextInt(81) + 20, EWolke.getWolke());
        wz.data(wd);
    }
}
