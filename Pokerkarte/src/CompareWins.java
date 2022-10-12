import java.util.Comparator;

public class CompareWins implements Comparator<Spieler> {
    @Override
    public int compare(Spieler o1, Spieler o2) {
        if(o1.anzWins > o2.anzWins){
            return -1;
        }
        if(o1.anzWins < o2.anzWins){
            return 1;
        }
        return 0;
    }
}
