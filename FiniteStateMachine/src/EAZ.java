public class EAZ {
    public Zustand z;
    public Eingabe e;
    public Ausgabe[] a;

    public EAZ(Eingabe e, Ausgabe[] a, Zustand z) {
        this.z = z;
        this.e = e;
        this.a = a;
    }
}
