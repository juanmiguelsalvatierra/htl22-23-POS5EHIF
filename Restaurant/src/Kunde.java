public class Kunde {
    public String name;
    public int orderTime;
    public int waiting;
    public int waited;

    public Kunde(String name){
        this.name = name;
    }

    public boolean Bestellung(){
        waited++;
        if (waited == waiting) {
            return true;
        }
        return false;
    }
}
