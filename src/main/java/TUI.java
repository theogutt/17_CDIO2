import java.util.Scanner;

public class TUI {
    private VægtController v;
    public TUI() throws Exception {
        v = new VægtController();
    }
    public void commandMenu() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMenu\n 1. Vis vægt\n 2. Tara vægt\n");
        int valg = sc.nextInt();
        if(valg==1){v.metoder(v.commandS());}
        else if(valg==2){v.metoder(v.commandT());}
    }
}
