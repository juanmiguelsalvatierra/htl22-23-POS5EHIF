public enum EWolke {
    klar(), leichtbewoelkt(), bewoelkt(), starkbewoelkt(), bedeckt();

    public static EWolke getWolke(){
        Random rn = new Random();
        return EWolke.values()[rn.nextInt(5)];
    }
}
