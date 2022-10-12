public enum Wert {
    Zwei(2), Drei(3), Vier(4), Fuenf(5), Sechs(6), Sieben(7),
    Acht(8), Neun(9), Zehn(10), Bube(11), Dame(12), Koenig(13), Ass(14);

    final int wert;

    Wert(int wert){
        this.wert = wert;
    }
}
