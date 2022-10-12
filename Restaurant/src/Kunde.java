import java.util.LinkedList;

public class Kunde {
    public String name;
    public int orderTime; // Benötigte Zeit zum bestellen
    public int orderTimeCount = 0; // Abgewartete Bestellzeit
    public int waiting; // WarteZeit
    public int waitingCount; // Gewartete Zeit
    public int avgWaitingTime = 0; // Insgesamte Wartezeit für eine Bestellung
    public LinkedList<Integer> avgTimeList = new LinkedList<>(); // Liste der insgesamten Wartezeiten
    public int avg = 0;
    public Kunde(String name){
        this.name = name;
    }

    public boolean BestellProcess(){
        waitingCount++;
        if(waiting >= waitingCount){
            return true;
        }
        return false;
    }

    public boolean Bestellung(){
        orderTimeCount++;
        if(orderTimeCount >= orderTime){
            return true;
        }
        return false;
    }

    public void CountAvg(){
        for(Integer temp : avgTimeList){
            avg += temp;
        }
        avg = avg / avgTimeList.size();
    }
}
