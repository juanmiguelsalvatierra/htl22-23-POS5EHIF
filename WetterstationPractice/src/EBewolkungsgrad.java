import java.util.Random;

public enum EBewolkungsgrad {
    klar, leichtbewoelkt, bewoelkt, starkbewoelkt, bedeckt;

    static Random rnd = new Random();

    public static EBewolkungsgrad getRandomWolke(){
        return EBewolkungsgrad.values()[EBewolkungsgrad.values().length];
    }
}
