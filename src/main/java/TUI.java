public class TUI {
    private VægtController v;
    public TUI() throws Exception {
        v = new VægtController();
    }

    public void run() throws Exception {
        v.forbind();
    }
}
