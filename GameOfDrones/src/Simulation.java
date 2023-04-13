import java.util.LinkedList;
import java.util.Random;

public class Simulation {
    public Feld[][] spielfeld = new Feld[10][7];
    public LinkedList<Drohne> dList = new LinkedList<>();

    public Simulation(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                spielfeld[i][j] = new Feld();
            }
        }
        Random rnd = new Random();
        dList.add(new Drohne("Grün",0, 1, true, true));
        dList.add(new Drohne("Grün",0, 3, true, true));
        dList.add(new Drohne("Grün",0, 5, true, true));

        dList.add(new Drohne("Rot",9, 1, true, false));
        dList.add(new Drohne("Rot",9, 3, true, false));
        dList.add(new Drohne("Rot",9, 5, true, false));
        for (int i = 1; i < 9; i++) {
            int r = rnd.nextInt(1, 7);
            spielfeld[i][r].hindernis = true;
        }
    }
    public void Go(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                if(spielfeld[j][i].hindernis == true){
                    System.out.print("X\t\t");
                } else if(spielfeld[j][i].drohneLinkedList.isEmpty()){
                    System.out.print("0\t\t");
                } else {
                    System.out.print("Y\t\t");
                }
            }
            System.out.print("\n");
        }
        while(true) {
            for (Drohne item : dList) {
                Move(item);
                System.out.println(item.farbe + " " + n item.x + " " + item.y);
            }
            System.out.println("----------------------------");
        }
    }

    public void Move(Drohne d){
        int x = d.x;
        int y = d.y;

        if(d.flugrichtung == true) {
            if (spielfeld[x + 1][y].hindernis == false) {
                d.x = x + 1;
            } else {
                if (d.ausweichRichtung == true) {
                    if (spielfeld[x][y + 1].hindernis == false) {
                        d.y = y + 1;
                    } else {
                        d.ausweichRichtung = false;
                    }
                }
                if (d.ausweichRichtung == false){
                    d.y = y-1;
                }
            }
        } else if(d.flugrichtung == false){
            if (spielfeld[x - 1][y].hindernis == false) {
                d.x = x - 1;
            } else {
                if (d.ausweichRichtung == true) {
                    if (spielfeld[x][y + 1].hindernis == false) {
                        d.y = y + 1;
                    } else {
                        d.ausweichRichtung = false;
                    }
                }
                if (d.ausweichRichtung == false){
                    d.y = y-1;
                }
            }
        }
    }
}
