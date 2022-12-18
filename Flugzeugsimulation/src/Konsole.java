import java.util.Scanner;

public class Konsole implements Runnable {

    public IKonsoleneingabe Flugzeug;

    public Konsole(IKonsoleneingabe Flugzeug){
        this.Flugzeug = Flugzeug;
    }

    @Override
    public void run() {
        while(true){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if(!s.isEmpty()){
                Flugzeug.eingabe(s);
            }
        }
    }
}
