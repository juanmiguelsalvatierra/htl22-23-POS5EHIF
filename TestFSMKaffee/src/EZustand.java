public enum EZustand {
    Start("1 -> Maschine einschalten"), On("Maschine an. 3 -> Kaffee machen / 4 -> Milch machen / 2 -> Ausschalten"),
    MakeCoffee(""), CoffeeDone(), MakeMilk(), MilkDone();

    String text;
    EZustand(String text){
        this.text = text;
    }
}
