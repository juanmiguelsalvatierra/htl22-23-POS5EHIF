import java.util.Random;

public class Skifahrer {
    public String name;
    public int dauer;
    public int angekommen = 0;
    public int anzAbfahrt;
    public int currentDauer = 0;
    public int pause = 0;
    public int huetteTime = 0;

    static Random rnd = new Random();

    public Skifahrer(String name, int dauer){
        this.name = name;
        if (dauer <= 31){
            this.dauer = rnd.nextInt(60) + 240;
        }
        if (dauer <= 76 && dauer > 31){
            this.dauer = rnd.nextInt(120) + 300;
        }
        else {
            this.dauer = rnd.nextInt(160) + 320;
        }
    }

    public boolean angekommencount(){
        this.angekommen++;
        if(angekommen == 324){
            this.angekommen = 0;
            return true;
        }
        return false;
    }

    public boolean dauercount(){
        this.currentDauer++;
        if(currentDauer == dauer){
            this.currentDauer = 0;
            return true;
        }
        return false;
    }

    public boolean pausecount(){
        if(pause >= 100){
            this.pause = 0;
            return true;
        }
        return false;
    }

    public boolean huettecount(){
        this.huetteTime++;
        if(huetteTime == 30){
            this.huetteTime = 0;
            return true;
        }
        return false;
    }
}
