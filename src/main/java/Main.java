public class Main {
    public static void main(String []args ) throws Exception {
        Bruger bruger1 = new Bruger(12, "Anders And");
        Batch batch1 = new Batch(1234,"Salt");

        TUI tui = new TUI();
        tui.afvejningsProcedure();
    }
}
