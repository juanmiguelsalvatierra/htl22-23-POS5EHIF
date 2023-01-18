import java.util.Scanner;

public class Flaschenautomat implements IAusgabe{
    IEingabe stateMachine;

    public void addListener(IEingabe stateMachine){
        this.stateMachine = stateMachine;
    }

    public void Go(){
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Gib eine Zahl ein 1-3");
            int eingabe = Integer.parseInt(s.nextLine());
            switch (eingabe){
                case 1 : stateMachine.Eingabe(Eingabe.Eins);
                break;
                case 2 : stateMachine.Eingabe(Eingabe.Zwei);
                break;
                case 3 : stateMachine.Eingabe(Eingabe.Knopf);
                break;
                default :
                    System.out.println("Falsche Eingabe");
            }
        }
    }
    @Override
    public void Ausgabe(Ausgabe[] a) {
        System.out.println(a);
    }
}
