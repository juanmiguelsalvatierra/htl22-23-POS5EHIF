import java.util.*;

public class Skisim {

    public Skisim() {
        Random rnd = new Random();
        int fahreranz = 161;
        int time = 0;
        LinkedList<Skifahrer> skilift = new LinkedList<>();
        LinkedList<Skifahrer> schlange = new LinkedList<>();
        LinkedList<Skifahrer> piste = new LinkedList<>();
        LinkedList<Skifahrer> huette = new LinkedList<>();
        LinkedList<Skifahrer> eliminieren = new LinkedList<>();
        int stucktime = 50;
        int liftanz = 0;

        for (int i = 0; i <= 160; i++) {
            schlange.add(new Skifahrer("Skifahrer" + i, rnd.nextInt(101)));
        }

        while (time < 28800) {
            if ((time % 7) == 0) { // Neuer Skifahrer stellt sich an
                schlange.add(new Skifahrer("Skifahrer" + fahreranz, rnd.nextInt(101)));
                fahreranz++;
            }
            if (rnd.nextInt(1000) <= 2) {
                stucktime = 0;
            }
            if (stucktime >= 50) { // Falls der Lift nicht stecken bleibt
                for (Skifahrer item : skilift) { // Skilift läuft durch
                    item.pause++;
                    if (item.angekommencount()) { // Skifahrer aussteigen lassen
                        Skifahrer aussteigen = item;
                        eliminieren.add(aussteigen);
                        if (item.pausecount()){ // Braucht der Skifahrer eine Pause?
                            huette.add(aussteigen); // Skifahrer kommt in die Huette
                        }
                        if (!item.pausecount()) { // Skifahrer braucht keine Pause
                            piste.add(aussteigen);
                        }
                    }
                }
                skilift.removeAll(eliminieren); // Skifahrer werden aus dem LIFT gelöscht
                eliminieren.clear();
                if ((time % 15) == 0) { // Skifahrer steigen in den Lift
                    int passagiere = rnd.nextInt(5);
                    for (int i = 0; i < passagiere; i++) {
                        liftanz++; // Transportierte werden erhöht
                        Skifahrer temp = schlange.getFirst();
                        schlange.remove(temp);
                        skilift.add(temp);
                    }
                }
            }

            for (Skifahrer item : huette){ // Huette wird durchgegangen
                if (item.huettecount()){ // Soll der Skifahrer wieder auf die Piste?
                    Skifahrer fertig = item;
                    eliminieren.add(fertig);
                    piste.add(fertig);
                }
            }
            huette.removeAll(eliminieren); // Skifahrer werden aus der HUETTE gelöscht
            eliminieren.clear();
            for (Skifahrer item : piste) { // Piste läuft durch
                item.pause++;
                if (item.dauercount()) { // Ist der Skifahrer unten?
                    //piste.remove(new Skifahrer(item.name, item.dauer));
                    eliminieren.add(item);
                    item.anzAbfahrt++;
                    if (item.anzAbfahrt == 1 || item.anzAbfahrt == 2){ // Abfahrten 1 - 2
                        schlange.add(item);
                    }
                    if (item.anzAbfahrt == 3){ // Abfahrt 3
                        if(rnd.nextInt(101) >= 15){
                            schlange.add(item);
                        }
                    }
                    if (item.anzAbfahrt >= 4 && item.anzAbfahrt <= 6){ // Abfahrt 4 - 6
                        if(rnd.nextInt(101) >= 20){
                            schlange.add(item);
                        }
                    }
                    if (item.anzAbfahrt >= 7 && item.anzAbfahrt <= 9){ // Abfahrt 7 - 9
                        if(rnd.nextInt(101) >= 45){
                            schlange.add(item);
                        }
                    }
                    if (item.anzAbfahrt >= 10 && item.anzAbfahrt <= 15){ // Abfahrt 10 - 15
                        if(rnd.nextInt(101) >= 15){
                            schlange.add(item);
                        }
                    }
                    if (item.anzAbfahrt > 15){ // Über 15 Abfahrten
                        if(rnd.nextInt(101) >= 5){
                            schlange.add(item);
                        }
                    }
                }
            }
            piste.removeAll(eliminieren);
            eliminieren.clear(); // Skifahrer werden aus der PISTE gelöscht
            stucktime++;
            time++;

            if (time % (30*60) == 0){
                System.out.println("#####################30 MINUTEN######################");
                System.out.println("Anzahl der Skifahrer auf der Piste: " + piste.size());
                System.out.println("Anzahl der Skifahrer im Lift: " + skilift.size());
                System.out.println("Anzahl der Skifahrer in der Huette: " + huette.size());
                System.out.println("Anzahl der Transportierten: " + liftanz);
                System.out.println("Anzahl der Skifahrer in der Schlange: " + schlange.size());
            }
        }
    }


}
