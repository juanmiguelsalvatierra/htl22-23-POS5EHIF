import java.util.LinkedList;
import java.util.Random;

public class Restaurant {
    static Random rnd = new Random();
    public int time = 1;
    LinkedList<Kunde> kunden = new LinkedList<>();
    LinkedList<Kunde> schlange = new LinkedList<>();
    LinkedList<Kunde> tempList = new LinkedList<>();
    public boolean wurdeBestellt = false;
    public int avgSum = 0;
    public int bestellteKunden = 0;
    public Kunde tempKunde;

    public Restaurant() {
        for (int i = 0; i < 20; i++) {
            kunden.add(new Kunde("Matze" + i));
            kunden.get(i).orderTime = rnd.nextInt(20, 41);
        }
    }

    public void Go() {
        while (time <= 28800) {
            for (Kunde item : kunden) {
                if (item.orderTime == 0) { // Wenn Kunde keine Wartezeit hat bekommt er wieder eine
                    item.orderTime = rnd.nextInt(20*60, 40*60);  // Kunden bekommen ihre Bestellzeit
                }
                if (item.waiting < 0) {
                    if (item.BestellProcess()) { // Bestellung vom Kunden wird bearbeitet
                        item.waiting = 0; // Kunde bekommt seine Bestellung; Seine Wartezeit wird resettet
                        item.orderTime = rnd.nextInt(20*60, 40*60);
                        wurdeBestellt = false;
                        tempList.add(item);
                        item.avgTimeList.add(item.avgWaitingTime);
                        item.CountAvg();
                    }
                }
            }
            kunden.addAll(tempList); // Bestellte Kunden kommen wieder in die Kundenliste
            tempList.clear();
            for (Kunde item : kunden) {
                if (item.Bestellung()) { // Abfrage ob der Kunde bestellt
                    schlange.add(item); // Kunde wird in die Schlange getan
                    tempList.add(item); // Kunde wird in die Lösch Liste getan
                    if(!wurdeBestellt) {
                        Kunde temp = schlange.getFirst();
                        temp.waiting = rnd.nextInt(1, 4); // Kunde bekommt eine Random Bestell Wartezeit
                        wurdeBestellt = true;
                    }
                }
            }
            if(wurdeBestellt){
                schlange.remove(tempList);
            }
            kunden.remove(tempList); // Kunden werden gelöscht aus der Liste gelöscht
            tempList.clear();
            for (Kunde item : schlange) {
                item.avgWaitingTime++;
            }


            if (time % 30 == 0) {
                for(Kunde item : kunden){
                    if(item.avg != 0){
                        avgSum += item.avg;
                        bestellteKunden++;
                    }
                }
                if(bestellteKunden != 0) {
                    avgSum = avgSum / bestellteKunden;
                }
                System.out.println("-----------------30 MINUTEN-----------------");
                System.out.println("Durschnittliche Wartezeit: " + avgSum);
                System.out.println(kunden.size());
                System.out.println(schlange.size());
            }
            time++;
        }
    }

    public void Go2(){
        while(time <= 28800){
            for (Kunde item : kunden){
                if(item.Bestellung()){ // Abfrage ob ein Kunde Bestellbereit ist
                    schlange.add(item); // Kunden werden in die Schlange getan
                    tempList.add(item);
                }
            }
            kunden.remove(tempList); // Kunden werden aus der Kundenliste entfernt
            tempList.clear();
            if(!schlange.isEmpty()) { // Abfrage ob die Schlange nicht leer ist
                for(Kunde item : schlange){
                    item.avgWaitingTime++;
                }
                if(!wurdeBestellt) {
                    tempKunde = schlange.getFirst();
                    tempKunde.waiting = rnd.nextInt(1, 4); // Erster Besteller bekommt eine Bearbeitungszeit
                    wurdeBestellt = true;
                    schlange.remove(tempKunde);
                }
            }
            if(wurdeBestellt){
                if(tempKunde.BestellProcess()){
                    kunden.add(tempKunde);

                    wurdeBestellt = false;
                }
            }
        }
    }
}
