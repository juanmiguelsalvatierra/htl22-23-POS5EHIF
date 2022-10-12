import java.util.Random;

public class Spieler {
    public int nr;
    public String name;
    public boolean jumped = false;
    static Random rnd = new Random();
    public int currentPos = 0;

    public Spieler(int nr, String name){
        this.nr = nr;
        this.name = name;
    }
    public void Jump(){ // todo
        if(!jumped){
            if(currentPos == 0){
                this.currentPos += rnd.nextInt(3) + 1;
                this.jumped = true;
                if(currentPos > 20){
                    this.currentPos = 20;
                }
                return;
            }
            if(currentPos != 0){
                this.currentPos += rnd.nextInt(4);
                this.jumped = true;
                if(currentPos > 20){
                    this.currentPos = 20;
                }
                return;
            }

        }
        return;
    }

    @Override
    public String toString(){
        return this.nr + " " + this.name + " befindet sich auf Feld " + currentPos;
    }
}
