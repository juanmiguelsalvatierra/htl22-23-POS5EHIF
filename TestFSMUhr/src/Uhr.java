import java.util.Scanner;

public class Uhr implements IAusgabe {
    IEingabe statemachine;

    @Override
    public void Ausgabe(EAusgabe ausg) {
        while (true) {
            System.out.println("1 / 2 / 12");
            Scanner sc = new Scanner(System.in);
            int eingabe = Integer.parseInt(sc.nextLine());
            switch (eingabe){
                case 1: statemachine.Eingabe(EEingabe.Eins);
                break;
                case 2: statemachine.Eingabe(EEingabe.Zwei);
                break;
                case 12: statemachine.Eingabe(EEingabe.Both);
                break;
            }
        }
    }
}
