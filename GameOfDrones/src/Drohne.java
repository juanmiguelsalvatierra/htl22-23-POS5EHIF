public class Drohne {
    String farbe;
    boolean ausweichRichtung, flugrichtung;
    int x, y;
    public Drohne(String farbe, int x, int y, boolean ausweichRichtung, boolean flugrichtung){
        this.farbe = farbe;
        this.x = x;
        this.y = y;
        this.ausweichRichtung = ausweichRichtung;
        this.flugrichtung = flugrichtung;
    }
}
