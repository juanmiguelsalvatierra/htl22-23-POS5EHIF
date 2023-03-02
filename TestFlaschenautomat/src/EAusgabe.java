public enum EAusgabe {
    Null("0"), Error("E"), Flasche("Flasche"), Eins("1"), Zwei("2"), Drei("3"), Return("Geld");

    public String text;

    EAusgabe(String text){
        this.text = text;
    }
}
