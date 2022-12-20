public class WetterDaten {
    public String ort;
    public EBewolkungsgrad bgrad;
    public int temp, lf;

    public WetterDaten(String ort, EBewolkungsgrad bgrad, int temp, int lf){
        this.ort = ort;
        this.bgrad = bgrad;
        this.temp = temp;
        this.lf = lf;
    }
}
