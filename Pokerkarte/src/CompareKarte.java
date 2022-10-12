import java.util.Comparator;

public class CompareKarte implements Comparator<Spieler> {
    @Override
    public int compare(Spieler o1, Spieler o2) {
        if(o1.currentKarte.wert.wert > o2.currentKarte.wert.wert){
            return -1;
        }
        if(o1.currentKarte.wert.wert < o2.currentKarte.wert.wert){
            return 1;
        }
        return 0;
    }
}
