import java.time.LocalTime;
import java.util.HashMap;

public class StateMachine implements IEingabe{
    IAusgabe kaffee;
    HashMap<EZustand, HashMap<EEingabe, EZustand>> states = new HashMap<>();

    public StateMachine(IAusgabe Kaffee){
        this.kaffee = kaffee;

        states.put(EZustand.);
        LocalTime currentime = LocalTime.now();
        LocalTime.of
    }


    @Override
    public void Eingabe(EEingabe eing) {

    }
}
