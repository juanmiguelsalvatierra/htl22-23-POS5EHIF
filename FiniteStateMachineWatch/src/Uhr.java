import java.util.Scanner;

public class Uhr implements IAusgabe{
    IEingabe sm;

    public void Go(){
        while(true){
            System.out.println("Bitte geben Sie eine Zahl ein");
            System.out.println("1 // 2  // 12");
            Scanner s = new Scanner(System.in);
            int eingabe = Integer.parseInt(s.nextLine());
            if(eingabe == 1){
                sm.Eingabe(EEingabe._1);
            }
            if(eingabe == 2){
                sm.Eingabe(EEingabe._2);
            }
            if(eingabe == 3){
                sm.Eingabe(EEingabe._12);
            }
        }
    }

    @Override
    public void Ausgabe(EAusgabe a) {

    }
}
