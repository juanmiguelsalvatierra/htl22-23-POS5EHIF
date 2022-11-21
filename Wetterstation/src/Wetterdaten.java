public class Wetterdaten {
    public String stadt;
    public int temp, luft;
    public EWolke wolke;

    public Wetterdaten(String stadt, int temp, int luft, EWolke wolke){
        this.stadt = stadt;
        this.temp = temp;
        this.luft = luft;
        this.wolke = wolke;
    }

    @Override
    public String toString(){
        return "Stadt: " + stadt + " Temp: "+ temp + " Luft: " + luft + " Bew: " + wolke.toString();
    }
}
