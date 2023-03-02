public class Main {
    public static void main(String[] args) {
        Automat a = new Automat();
        StateMachine sm = new StateMachine(a);
        a.addListener(sm);
        a.Go();
    }
}