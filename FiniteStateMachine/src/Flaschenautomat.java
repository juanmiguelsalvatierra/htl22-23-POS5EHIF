import java.util.Scanner;

public class Flaschenautomat implements IAusgabe{
    IEingabe stateMachine;

    public void addListener(IEingabe stateMachine){
        this.stateMachine = stateMachine;
    }

    public void Go(){
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Gib geben Sie eine Zahl ein (1: 1 Euro, 2: 2 Euro, 3: Knopf)");
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
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + ", ");
        }
        System.out.println();
    }
}
