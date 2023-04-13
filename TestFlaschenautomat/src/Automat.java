import java.util.Scanner;

public class Automat implements IAusgabe{
    IEingabe statemachine;
    public void addListener(IEingabe statemachine){
        this.statemachine = statemachine;
    }
    public void Go(){
        while(true){
            System.out.println("Bitte geben Sie eine Zahl ein");
            Scanner sc = new Scanner(System.in);
            int eingabe = Integer.parseInt(sc.nextLine());
            switch (eingabe){
                case 1:
                    statemachine.Eingabe(EEingabe.Eins);
                    break;
                case 2:
                    statemachine.Eingabe(EEingabe.Zwei);
                    break;
                case 3:
                    statemachine.Eingabe(EEingabe.Knopf);
                    break;
            }
        }
    }
    @Override
    public void Ausgabe(EZustand zustand) {
        for(EAusgabe item : zustand.ausg){
            System.out.println(item.text);
        }

    }
}
