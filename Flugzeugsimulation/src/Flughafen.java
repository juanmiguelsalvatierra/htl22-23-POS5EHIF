public class Flughafen implements ISend, Runnable{
    public Flugzeug f1;
    public int counter = 0;

    public Flughafen(){
        this.f1 = new Flugzeug(300, 10000, 111.1f, this);
    }

    @Override
    public void DatenInfo(float distanz, float hoehe, float speed) {

    }

    @Override
    public void Gelandet() {

    }

    @Override
    public void run() {
        while(true){
            if(counter <= 20){

            }
            if(counter == 20){

            }
        }
    }
}
