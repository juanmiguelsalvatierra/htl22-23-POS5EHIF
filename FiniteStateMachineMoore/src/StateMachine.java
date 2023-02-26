import java.util.LinkedList;

public class StateMachine implements IEingabe{
    IAusgabe Automat;
    EZustand current = EZustand.Start;
    int currentind = 0;
    public LinkedList<LinkedList<EZ>> sm = new LinkedList<>();

    public StateMachine(IAusgabe Automat){
        this.Automat = Automat;
        for(int i = 0; i < 10; i++){
            sm.add(new LinkedList<EZ>());
        }
        sm.get(0).add(new EZ(EEingabe.Eins, EZustand.Z1));
    }
    @Override
    public void Eingabe(EEingabe e) {
        for(int i = 0; i < sm.size(); i++){
            if (sm.get(currentind).get(i).eing == e) {
                current = sm.get(currentind).get(i).zustand;
                currentind = i;
                break;
            }
        }
        Automat.Ausgabe(current);
    }
}
