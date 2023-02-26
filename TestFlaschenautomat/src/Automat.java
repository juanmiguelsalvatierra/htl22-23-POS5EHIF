import java.util.Scanner;

public class Automat implements IAusgabe{
    IEingabe statemachine;
    public Automat(){
        while(true){
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

    }
}
