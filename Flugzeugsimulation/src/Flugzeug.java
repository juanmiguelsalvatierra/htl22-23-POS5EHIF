public class Flugzeug implements IRequest, IKonsoleneingabe, Runnable {
    public float hoehe, speed, distanz;
    public ISend isend;

    public Flugzeug(float hoehe, float distanz, float speed, ISend isend){
        this.hoehe = hoehe;
        this.distanz = distanz;
        this.speed = speed;
        this.isend = isend;
    }

    @Override
    public void DatenAnfrage() {

    }

    public void calcAltDist(){
        this.hoehe = this.hoehe - (5f*0.1f);
        this.distanz = this.distanz + (speed/10);
    }

    public void addSpeed(){
        this.speed = this.speed + 10;
    }

    public void subSpeed(){
        this.speed = this.speed - 10;
    }


    @Override
    public void eingabe(String e) {
        if(e.equals("+")){
            addSpeed();
        }
        if(e.equals("-")){
            subSpeed();
        }
    }

    @Override
    public void run() {
        this.hoehe = this.hoehe - (5f*0.1f);
        this.distanz = this.distanz + (speed/10);
    }
}
