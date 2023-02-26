public enum EZustand {
    Start(new EAusgabe[] {EAusgabe.Null}), Z1(new EAusgabe[] {EAusgabe.Eins}),
    Z2(new EAusgabe[] {EAusgabe.Zwei}), Z3(new EAusgabe[] {EAusgabe.Drei}),
    Z4(new EAusgabe[] {EAusgabe.Error}), Z5(new EAusgabe[] {EAusgabe.Error}),
    Z6(new EAusgabe[] {EAusgabe.Error}), Zhoch(new EAusgabe[] {EAusgabe.Error}),
    ZF(new EAusgabe[] {EAusgabe.Null, EAusgabe.Flasche}), ZR(new EAusgabe[] {EAusgabe.Null, EAusgabe.Flasche, EAusgabe.Return});

    public EAusgabe[] ausg;

    EZustand(EAusgabe[] ausg){
        this.ausg = ausg;
    }
}
