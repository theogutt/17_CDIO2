import java.util.Scanner;

public class TUI {
    private VægtController v;
    public TUI() throws Exception {
        v = new VægtController();
    }
    public void commandMenu() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMenu\n 1. Vis vægt\n 2. Tara vægt\n 3.skriver ord i veje display\n 4.retunerer til vægt visning\n 5. plads til 30 karakterer\n 6.Skriver INDTAST NR " +
                "Afventer indtastning (her 123)som så retunerer: RM20 A ”123” crlf \n");
        int valg = sc.nextInt();
        if(valg==1){v.metoder(v.commandS());}
        else if(valg==2){v.metoder(v.commandT());}
        else if(valg==3){v.metoder(v.commandD(output()));}
        else if(valg==4){v.metoder(v.commandDW());}
        else if(valg==5){v.metoder(v.commandP111(output()));}
        else if(valg==6){v.metoder(v.commandRM20(output()));}

    }
    public String output(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indtast ord: ");
        String output = sc.next();
        return output;
    }
}
