import java.util.Scanner;

public class Automat implements IAusgabe{
    IEingabe sm;

    public void Go(){
        Scanner s = new Scanner(System.in);
        int eingabe = Integer.parseInt(s.nextLine());
        while(true){
            System.out.println("Bitte geben Sie eine Zahl ein");
            System.out.println("1 => 1 Euro // 2 => 2 Euro // 3 => Knopf");
            if(eingabe == 1){
                sm.Eingabe(EEingabe.Eins);
            }
            if(eingabe == 2){
                sm.Eingabe(EEingabe.Zwei);
            }
            if(eingabe == 3){
                sm.Eingabe(EEingabe.Knopf);
            }
        }
    }

    @Override
    public void Ausgabe(EZustand z) {

    }
}
