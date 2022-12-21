import java.util.Random;

public class Wohn extends Gebaeude{
    Random rnd = new Random();
    public Wohn(int x, int y){
        super(x,y);
    }

    @Override
    public void wackeln(int x, int y) {
        double dist = Math.sqrt((Math.pow(this.x - x, 2) + Math.pow(this.y -y, 2)));
        if(dist < 7){
            if(rnd.nextInt(100) < 50){
                System.out.println("Öffentliches Gebäude wackelt!");
                System.out.println("Position: X: " + this.x + " Y: " +  this.y);
                System.out.println("Distanz: " + dist);
            }
        }
    }
}
