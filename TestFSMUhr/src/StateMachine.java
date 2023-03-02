import java.util.HashMap;

public class StateMachine implements IEingabe {
    IAusgabe aut;

    HashMap<EZustand, HashMap<EEingabe, EZustand>> stateMachine = new HashMap<>();

    public void StateMachine(IAusgabe aut){
        this.aut = aut;
        stateMachine.put(EZustand.Start, new HashMap<>());
        stateMachine.put(EZustand.Datum, new HashMap<>());
        stateMachine.put(EZustand.HH, new HashMap<>());
        stateMachine.put(EZustand.HHAdd, new HashMap<>());
        stateMachine.put(EZustand.MM, new HashMap<>());
        stateMachine.put(EZustand.MMAdd, new HashMap<>());
        stateMachine.put(EZustand.SS, new HashMap<>());
        stateMachine.put(EZustand.SSAdd, new HashMap<>());
        stateMachine.put(EZustand.dd, new HashMap<>());
        stateMachine.put(EZustand.ddAdd, new HashMap<>());
        stateMachine.put(EZustand.mm, new HashMap<>());
        stateMachine.put(EZustand.mmAdd, new HashMap<>());
        stateMachine.put(EZustand.yy, new HashMap<>());
        stateMachine.put(EZustand.yyAdd, new HashMap<>());

        stateMachine.get(EZustand.Start).put(EEingabe.Eins, EZustand.Datum);
        stateMachine.get(EZustand.Start).put(EEingabe.Zwei, EZustand.Start);
        stateMachine.get(EZustand.Start).put(EEingabe.Both, EZustand.HH);

        stateMachine.get(EZustand.HH).put(EEingabe.Eins, EZustand.HHAdd);
        stateMachine.get(EZustand.HH).put(EEingabe.Zwei, EZustand.Start);
        stateMachine.get(EZustand.HH).put(EEingabe.Both, EZustand.HH);

    }
    @Override
    public void Eingabe(EEingabe eing) {

    }
}
