import java.util.HashMap;
import java.util.LinkedList;

public class WetterZentrale implements IRespondData {
    IRequestData[] wetterStation = new Wetterstation[5];
    HashMap<String, Wetterdaten> wetterdaten = new HashMap<String, Wetterdaten>();

    public WetterZentrale(){
        wetterStation[0] = new Wetterstation("Wien", this);
        wetterStation[1] = new Wetterstation("Moskua", this);
        wetterStation[2] = new Wetterstation("Tokyo", this);
        wetterStation[3] = new Wetterstation("Bangkok", this);
        wetterStation[4] = new Wetterstation("Kapstadt", this);
    }

    public void werteAbfragen(){
        for(IRequestData w : wetterStation){
            w.getData(); // Wetterstation anfragen
        }
    }

    // Diese Methode wird von einer Wetterstation aufgerufen
    @Override
    public void data(Wetterdaten data) {
        // sind alle Wetterdaten eingelangt?
        if(wetterdaten.size() < 5) { // nein daten eintragen
            wetterdaten.put(data.getStadt(), data);
        }

        if(wetterdaten.size() == 5){
            Iterator<WetterDaten> it = wetterdaten.values().iterator();
            while(it.hasNext()){
                WetterDaten tmp = it.next();
            }
        }
    }
}
