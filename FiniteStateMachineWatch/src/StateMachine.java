import java.util.LinkedList;

public class StateMachine implements IEingabe{

    IAusgabe uhr;

    public LinkedList<LinkedList<EZ>> stateMachine = new LinkedList<>();

    public StateMachine(IAusgabe uhr){
        this.uhr = uhr;
        for (int i = 0; i < 14; i++) {
            stateMachine.add(new LinkedList<EZ>());
        }
        stateMachine.get(0).add(new EZ(EEingabe._1, EAusgabe._))
    }
    @Override
    public void Eingabe(EEingabe e) {

    }
}
