public class Main {
    public static void main(String[] args) {
        Flaschenautomat fa = new Flaschenautomat();
        StateMachine s = new StateMachine(fa);
        fa.addListener(s);
    }
}