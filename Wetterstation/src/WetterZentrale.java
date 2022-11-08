import java.util.LinkedList;

public class WetterZentrale implements IRespondData {
    IRequestData[] wetterStation = new WetterStation[5];
    HashMap<String, WetterDaten> wetterdaten = new HashMap<String, WetterDaten>();

    public WetterZentrale(){
        wetterStation[0] = new WetterStation("Wien", this);
        wetterStation[1] = new WetterStation("Moskua", this);
        wetterStation[2] = new WetterStation("Tokyo", this);
        wetterStation[3] = new WetterStation("Bangkok", this);
        wetterStation[4] = new WetterStation("Kapstadt", this);
    }

    public void werteAbfragen(){
        for(IRequestData w : wetterStation){
            w.getData(); // Wetterstation anfragen
        }
    }

    // Diese Methode wird von einer Wetterstation aufgerufen
    @Override
    public void data(WetterDaten data) {
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
