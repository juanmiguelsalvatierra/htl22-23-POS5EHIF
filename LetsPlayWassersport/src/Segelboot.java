public class Segelboot extends Boot{
    public int anzSegel;
    public Segelboot(int nr, float speed, IFertig rennleitung, int anzSegel) {
        super(nr, speed, rennleitung);
        this.anzSegel = anzSegel;
    }

    @Override
    public void wind() {
        int wsl = rnd.nextInt(100);
        if(wsl < 51){
            System.out.println("Segelboot Nr: " + nr + " ist gekentert, es gibt auf");
            rennleitung.kentern(this);
        }
        speed += 0.3;
        gekentert = true;
    }
}
