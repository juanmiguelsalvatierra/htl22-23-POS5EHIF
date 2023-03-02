public enum EZustand {
    Start("Uhrzeit: "), Datum("Datum: "), HH("Stunde erhöhen"), HHAdd("Stunde erhöht"),
    MM("Minute eröhen"), MMAdd("Minute erhöht"), SS("Sekunde erhöhen"), SSAdd("Sekunde erhöht"),
    dd("Tag erhöhen"), ddAdd("Tag erhöht"), mm("Monat erhöhen"), mmAdd("Monat erhöht"),
    yy("Jahr erhöhen"), yyAdd("Jahr erhöht");

    String text;
    EZustand(String text){
        this.text = text;
    }
}
