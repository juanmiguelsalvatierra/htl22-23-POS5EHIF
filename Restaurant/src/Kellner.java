public class Kellner {
    public String name;
    public int proTime; // Bearbeitete Zeit
    public int orderTime; // Zeit zu bearbeiten

    public Kellner(String name){
        this.name = name;
    }

    public boolean Process(){
        proTime++;
        if(proTime == orderTime){
            return true;
        }
        return false;
    }
}
