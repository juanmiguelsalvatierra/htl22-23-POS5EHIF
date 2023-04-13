import java.util.HashMap;
import java.util.LinkedList;

public class StateMachine implements IEingabe {
    IAusgabe aut;
    HashMap<EZustand, HashMap<EEingabe, EZustand>> hashstates = new HashMap<>();
    EZustand currentstate = EZustand.Start;
    public StateMachine(IAusgabe aut){
        this.aut = aut;
        hashstates.put(EZustand.Start, new HashMap<>());
        hashstates.put(EZustand.Z1, new HashMap<>());
        hashstates.put(EZustand.Z2, new HashMap<>());
        hashstates.put(EZustand.Z3, new HashMap<>());
        hashstates.put(EZustand.Z4, new HashMap<>());
        hashstates.put(EZustand.Z5, new HashMap<>());
        hashstates.put(EZustand.Z6, new HashMap<>());
        hashstates.put(EZustand.Zhoch, new HashMap<>());
        hashstates.put(EZustand.ZF, new HashMap<>());
        hashstates.put(EZustand.ZR, new HashMap<>());

        hashstates.get(EZustand.Start).put(EEingabe.Eins, EZustand.Z1);
        hashstates.get(EZustand.Start).put(EEingabe.Zwei, EZustand.Z2);
        hashstates.get(EZustand.Start).put(EEingabe.Knopf, EZustand.Z1);

        hashstates.get(EZustand.Z1).put(EEingabe.Eins, EZustand.Z2);
        hashstates.get(EZustand.Z1).put(EEingabe.Zwei, EZustand.Z3);
        hashstates.get(EZustand.Z1).put(EEingabe.Knopf, EZustand.Z5);

        hashstates.get(EZustand.Z2).put(EEingabe.Eins, EZustand.Z3);
        hashstates.get(EZustand.Z2).put(EEingabe.Zwei, EZustand.Zhoch);
        hashstates.get(EZustand.Z2).put(EEingabe.Knopf, EZustand.Z6);

        hashstates.get(EZustand.Z3).put(EEingabe.Eins, EZustand.Zhoch);
        hashstates.get(EZustand.Z3).put(EEingabe.Zwei, EZustand.Zhoch);
        hashstates.get(EZustand.Z3).put(EEingabe.Knopf, EZustand.ZF);

        hashstates.get(EZustand.Z4).put(EEingabe.Eins, EZustand.Z1);
        hashstates.get(EZustand.Z4).put(EEingabe.Zwei, EZustand.Z2);
        hashstates.get(EZustand.Z4).put(EEingabe.Knopf, EZustand.Z4);

        hashstates.get(EZustand.Z5).put(EEingabe.Eins, EZustand.Z2);
        hashstates.get(EZustand.Z5).put(EEingabe.Zwei, EZustand.Z3);
        hashstates.get(EZustand.Z5).put(EEingabe.Knopf, EZustand.Z5);

        hashstates.get(EZustand.Z6).put(EEingabe.Eins, EZustand.Z3);
        hashstates.get(EZustand.Z6).put(EEingabe.Zwei, EZustand.Zhoch);
        hashstates.get(EZustand.Z6).put(EEingabe.Knopf, EZustand.Z6);

        hashstates.get(EZustand.Zhoch).put(EEingabe.Eins, EZustand.Zhoch);
        hashstates.get(EZustand.Zhoch).put(EEingabe.Zwei, EZustand.Zhoch);
        hashstates.get(EZustand.Zhoch).put(EEingabe.Knopf, EZustand.ZR);

        hashstates.get(EZustand.ZF).put(EEingabe.Eins, EZustand.Z1);
        hashstates.get(EZustand.ZF).put(EEingabe.Zwei, EZustand.Z2);
        hashstates.get(EZustand.ZF).put(EEingabe.Knopf, EZustand.Z4);

        hashstates.get(EZustand.ZR).put(EEingabe.Eins, EZustand.Z1);
        hashstates.get(EZustand.ZR).put(EEingabe.Zwei, EZustand.Z2);
        hashstates.get(EZustand.ZR).put(EEingabe.Knopf, EZustand.Z4);
    }
    @Override
    public void Eingabe(EEingabe eingabe) {
        EZustand temp = hashstates.get(currentstate).get(eingabe);
        aut.Ausgabe(temp);
        currentstate = temp;
    }
}
