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
        sm.get(0).add(new EAZ(Eingabe.Zwei, new Ausgabe[] {Ausgabe.Zwei}, Zustand.Z2));
        sm.get(0).add(new EAZ(Eingabe.Knopf, new Ausgabe[] {Ausgabe.Error}, Zustand.Start));

        sm.get(1).add(new EAZ(Eingabe.Eins, new Ausgabe[] {Ausgabe.Zwei}, Zustand.Z2));
        sm.get(1).add(new EAZ(Eingabe.Zwei, new Ausgabe[] {Ausgabe.Drei}, Zustand.Z3));
        sm.get(1).add(new EAZ(Eingabe.Knopf, new Ausgabe[] {Ausgabe.Error}, Zustand.Z1));

        sm.get(2).add(new EAZ(Eingabe.Eins, new Ausgabe[] {Ausgabe.Drei}, Zustand.Z3));
        sm.get(2).add(new EAZ(Eingabe.Zwei, new Ausgabe[] {Ausgabe.Error}, Zustand.ZRetour));
        sm.get(2).add(new EAZ(Eingabe.Knopf, new Ausgabe[] {Ausgabe.Error}, Zustand.Z2));

        sm.get(3).add(new EAZ(Eingabe.Eins, new Ausgabe[] {Ausgabe.Error}, Zustand.ZRetour));
        sm.get(3).add(new EAZ(Eingabe.Zwei, new Ausgabe[] {Ausgabe.Error}, Zustand.ZRetour));
        sm.get(3).add(new EAZ(Eingabe.Knopf, new Ausgabe[] {Ausgabe.Drink, Ausgabe.Null}, Zustand.Start));

        sm.get(4).add(new EAZ(Eingabe.Eins, new Ausgabe[] {Ausgabe.Error}, Zustand.ZRetour));
        sm.get(4).add(new EAZ(Eingabe.Zwei, new Ausgabe[] {Ausgabe.Error}, Zustand.ZRetour));
        sm.get(4).add(new EAZ(Eingabe.Knopf, new Ausgabe[] {Ausgabe.Drink, Ausgabe.Null, Ausgabe.Retour}, Zustand.Start));
    }

    @Override
    public void Eingabe(Eingabe e) {
        for (EAZ item : sm.get(current.index)) {
            if (item.e == e){
                current = item.z;
                flaschenautomat.Ausgabe(item.a);
            }
        }
        System.out.println("Zustand: " + current);
    }
}
