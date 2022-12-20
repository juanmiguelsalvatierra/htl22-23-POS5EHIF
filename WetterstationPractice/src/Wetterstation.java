public class Wetterstation implements IAnfrage{
    public String ort;
    public ISenden zentrale;

    public Wetterstation(String ort, ISenden zentrale){
        this.ort = ort;
        this.zentrale = zentrale;
    }

    @Override
    public void send() {

    }
}
