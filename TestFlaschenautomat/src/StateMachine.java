import java.util.LinkedList;

public class StateMachine implements IEingabe {
    IAusgabe aut;
    LinkedList<LinkedList<EZ>> states = new LinkedList<>();
    public StateMachine(IAusgabe aut){
        this.aut = aut;

        for (int i = 0; i < 10; i++) {
            states.add(new LinkedList<>());
        }

        states.get(0).add(new EZ(EEingabe.Eins, EZustand.Z1));
        states.get(0).add(new EZ(EEingabe.Zwei, EZustand.Z2));
        states.get(0).add(new EZ(EEingabe.Knopf, EZustand.Z1));

        states.get(1).add(new EZ(EEingabe.Eins, EZustand.Z2));
        states.get(1).add(new EZ(EEingabe.Zwei, EZustand.Z3));
        states.get(1).add(new EZ(EEingabe.Knopf, EZustand.Z5));

        states.get(2).add(new EZ(EEingabe.Eins, EZustand.Z3));
        states.get(2).add(new EZ(EEingabe.Zwei, EZustand.Zhoch));
        states.get(2).add(new EZ(EEingabe.Knopf, EZustand.Z6));

        states.get(3).add(new EZ(EEingabe.Eins, EZustand.Zhoch));
        states.get(3).add(new EZ(EEingabe.Zwei, EZustand.Zhoch));
        states.get(3).add(new EZ(EEingabe.Knopf, EZustand.ZF));

        states.get(4).add(new EZ(EEingabe.Eins, EZustand.Z1));
        states.get(4).add(new EZ(EEingabe.Zwei, EZustand.Z2));
        states.get(4).add(new EZ(EEingabe.Knopf, EZustand.Z4));

        states.get(5).add(new EZ(EEingabe.Eins, EZustand.Z2));
        states.get(5).add(new EZ(EEingabe.Zwei, EZustand.Z3));
        states.get(5).add(new EZ(EEingabe.Knopf, EZustand.Z5));

        states.get(6).add(new EZ(EEingabe.Eins, EZustand.Z3));
        states.get(6).add(new EZ(EEingabe.Zwei, EZustand.Zhoch));
        states.get(6).add(new EZ(EEingabe.Knopf, EZustand.Z6));

        states.get(7).add(new EZ(EEingabe.Eins, EZustand.Zhoch));
        states.get(7).add(new EZ(EEingabe.Zwei, EZustand.Zhoch));
        states.get(7).add(new EZ(EEingabe.Knopf, EZustand.ZR));

        states.get(8).add(new EZ(EEingabe.Eins, EZustand.Z1));
        states.get(8).add(new EZ(EEingabe.Zwei, EZustand.Z2));
        states.get(8).add(new EZ(EEingabe.Knopf, EZustand.Z4));

        states.get(9).add(new EZ(EEingabe.Eins, EZustand.Z1));
        states.get(9).add(new EZ(EEingabe.Zwei, EZustand.Z2));
        states.get(9).add(new EZ(EEingabe.Knopf, EZustand.Z4));
    }
    @Override
    public void Eingabe(EEingabe eingabe) {

    }
}
