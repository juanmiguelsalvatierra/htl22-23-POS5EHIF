public enum EZustand {
    Start(new EAusgabe[] {EAusgabe.Zero}), ZR(new EAusgabe[] {EAusgabe.Zero, EAusgabe.Flasche, EAusgabe.Geld}),
    ZF(new EAusgabe[] {EAusgabe.Zero, EAusgabe.Flasche}), Z1(new EAusgabe[] {EAusgabe.Eins}),
    Z2(new EAusgabe[] {EAusgabe.Zwei}), Z3(new EAusgabe[] {EAusgabe.Drei}), Z4(new EAusgabe[] {EAusgabe.Error}),
    Z5(new EAusgabe[] {EAusgabe.Error}), Z6(new EAusgabe[] {EAusgabe.Error}), Zh(new EAusgabe[] {EAusgabe.Error});

    public EAusgabe[] ausg;

    EZustand(EAusgabe[] ausg){
        this.ausg = ausg;
    }
}
