public class Kajak extends Boot{
    public int laenge;
    public Kajak(int nr, float speed, IFertig rennleitung, int laenge) {
        super(nr, speed, rennleitung);
        this.laenge = laenge;
    }

    @Override
    public void wind() throws InterruptedException {
        int wsl = rnd.nextInt(100);
        if(wsl < 41){
            System.out.println("Segelboot Nr: " + nr + " ist gekentert");
            Thread.sleep(5000);
        }
        speed += 0.1;
        gekentert = true;
    }
}
