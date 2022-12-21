import java.util.LinkedList;
import java.util.Random;

public class Rennleitung implements IFertig {
    public LinkedList<IWind> teilnehmer = new LinkedList<>();
    public LinkedList<Thread> threadlist = new LinkedList<>();
    public LinkedList<IWind> angekommen = new LinkedList<>();
    public LinkedList<IWind> temp = new LinkedList<>();
    public int counter = 0;
    static Random rnd = new Random();

    public Rennleitung(){
        for (int i = 0; i < 10; i++) {
            int wsl = rnd.nextInt(101);
            float speed = (rnd.nextInt(14)+27)/10;
            if(wsl < 34){
                teilnehmer.add(new Segelboot(i+1, speed, this, rnd.nextInt(2)+1));
            } else {
                teilnehmer.add(new Kajak(i+1, speed, this, rnd.nextInt(100) +500));
            }
        }
    }

    public void Go() throws InterruptedException {
        for (IWind item : teilnehmer){
            threadlist.add(new Thread((Runnable) item));
        }

        for (Thread item : threadlist){
            item.start();
        }

        while(teilnehmer.size() > 0){
            Thread.sleep(1000);
            counter++;

            if(counter % 5 == 0){
                System.out.println("------------------------- Zwischenstand -------------------------");
                System.out.println("\tAnzahl der Boote im Ziel ... : " + angekommen.size());
                System.out.println("\tAkutelle Zeit .............. : " + counter);
                System.out.println(teilnehmer);
                System.out.println("---------------------- Zwischenstand Ende -----------------------");
            }
            if(counter == 20){
                for(IWind item : teilnehmer){
                    item.wind();
                }
                teilnehmer.removeAll(temp);
                temp.clear();
            }
        }
        System.out.println("DAS RENNEN IST FERTIG");
        System.out.println(angekommen);
        for (Thread item : threadlist){
            item.interrupt();
        }
    }

    @Override
    public void kentern(IWind boot) {
        temp.add(boot);
        threadlist.get(threadlist.indexOf(boot)).interrupt();
    }

    @Override
    public void finish(IWind boot) {
        teilnehmer.remove(boot);
        angekommen.add(boot);
    }
}
