import java.util.LinkedList;

public class RennenV1 {
    public LinkedList<Spieler>[] strecke = new LinkedList[20];
    public LinkedList<Spieler> delete = new LinkedList<>();
    public RennenV1(){
        for(int i = 0; i < 20; i++){
            strecke[i] = new LinkedList<>();
        }
        for(int i = 0; i < 20; i++){
            strecke[0].add(new Spieler(i, "Matthias" + i));
        }
    }

    public void Go(){
        while(strecke[19].size() < 2){
            for(int i = 0; i < 20; i++){
                for(Spieler item : strecke[i]){
                    item.Jump();
                }
            }
            for(int i = 0; i < 20; i++){
                for(Spieler item : strecke[i]){
                    item.jumped = false;
                }
            }

            for(int i = 0; i < 20; i++){
                for(int j = 0; j < strecke[i].size(); j++){
                    Spieler temp = strecke[i].get(j);
                    strecke[temp.currentPos].add(temp);
                    strecke[i].remove(temp);
                }
            }
            System.out.println("-----------------1 Runde-----------------");
            for(int i = 0; i < 20; i++){
                for(Spieler item : strecke[i]){
                    if(!strecke[i].isEmpty()) {
                        System.out.println(item.nr + " " + item.name + " befindet sich auf dem Feld " + item.currentPos);
                    }
                }
            }
        }
        System.out.println("Das Rennen ist beendet");
    }
}
