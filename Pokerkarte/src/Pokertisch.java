import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Pokertisch {
    public LinkedList<Spieler> spielerList = new LinkedList<>();
    public Stack<Karte> stapel = new Stack<>();
    public Pokertisch(){
        spielerList.add(new Spieler("Matthias"));
        spielerList.add(new Spieler("Juan"));
        spielerList.add(new Spieler("Momo"));
        spielerList.add(new Spieler("Harun"));

        for(Wert i : Wert.values()){
            stapel.push(new Karte(Farbe.Herz, i));
            stapel.push(new Karte(Farbe.Karo, i));
            stapel.push(new Karte(Farbe.Pik, i));
            stapel.push(new Karte(Farbe.Kreuz, i));
        }

    }
    public void Go(){
        Collections.shuffle(stapel);
        while(stapel.size() > spielerList.size()){
            for(Spieler item : spielerList){
                item.currentKarte = stapel.pop();
                System.out.println(item.name + " zieht die Karte " + item.currentKarte.farbe.bez + " " + item.currentKarte.wert.wert);
            }
            LinkedList<Spieler> tempList = spielerList;
            Collections.sort(tempList, new CompareKarte());
            Spieler winner = tempList.getFirst();
            winner.anzWins++;
            System.out.println(winner.name + " hat die Runde gewonnen! Anzahl der Siege: " + winner.anzWins);
        }
        LinkedList<Spieler> winList = spielerList;
        Collections.sort(winList, new CompareWins());
        Spieler gameWinner = winList.getFirst();
        System.out.println(gameWinner.name + " hat das Spiel gewonnen! Anzahl der Siege: " + gameWinner.anzWins);
    }
}
