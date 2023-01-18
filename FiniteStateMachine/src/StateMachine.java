import java.util.LinkedList;

public class StateMachine implements IEingabe{
    IAusgabe flaschenautomat;
    LinkedList<LinkedList<EAZ>> sm = new LinkedList<>();
    Zustand current = Zustand.Start;

    public StateMachine(IAusgabe flaschenautomat){
        this.flaschenautomat = flaschenautomat;
        for (int i = 0; i < 5; i++) {
            sm.add(new LinkedList<EAZ>());
        }
        sm.get(0).add(new EAZ(Eingabe.Eins, new Ausgabe[] {Ausgabe.Eins}, Zustand.Z1));
        sm.get(0).add(new EAZ(Eingabe.Zwei))
    }

    @Override
    public void Eingabe(Eingabe e) {
        for (EAZ item : sm.get(current.index)) {
            if (item.e == e){
                current = item.z;
                flaschenautomat.Ausgabe(item.a);
            }
        }
    }
}
