import java.util.LinkedList;

public class WetterZentrale implements ISchicken {
    public LinkedList<Wetterstation> wsList = new LinkedList<>();

    public WetterZentrale(){
        wsList.add(new Wetterstation("Wien"));
        wsList.add(new Wetterstation("Moskau"));
        wsList.add(new Wetterstation("Tokyo"));
        wsList.add(new Wetterstation("Bangkok"));
        wsList.add(new Wetterstation("Kapstadt"));
    }

    @Override
    public void WetterDaten() {

    }
}
