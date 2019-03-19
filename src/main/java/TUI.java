import java.io.IOException;
import java.util.Scanner;

public class TUI {
    private VægtController v;
    private Bruger bruger;
    private Batch batch;
    public TUI() throws Exception {
        bruger = new Bruger(12, "Anders And");
        batch = new Batch(1234, "Salt");
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
        else if(valg==6){v.metoder(v.commandRM20(output(), output()));}

    }
    public String output(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indtast ord: ");
        String output = sc.next();
        return output;
    }
    public void afvejningsProcedure() throws IOException {
        //trin 1,2
        v.metoder(v.commandRM20("INDTAST OPERATØRNUMMER", "12"));
        //trin 2 måske
        //v.metoder(v.commandP111(output()));
        //trin 3
        v.metoder(v.commandD(bruger.getNavn()));
        //trin 4
        v.metoder(v.commandD("Indtast batchnummer"));
        //trin 5
        v.metoder(v.commandP111(output()));
        //trin 6 - operatøren kvitterer for at navnet er korrekt
        v.metoder(v.commandRM20("Godkend", "OK"));
        //trin 7
        v.metoder(v.commandT());
        //trin 8 - operatøren kvitterer
        v.metoder(v.commandRM20("Godkend", "OK"));
        //trin 9 - vægten er blevet tareret
        //trin 10
        v.metoder(v.commandD("Placer tara"));
        //trin 11 - operatøren kvitterer
        v.metoder(v.commandRM20("Godkend", "OK"));
        //trin 12
        v.metoder(v.commandS());
        //trin 13
        v.metoder(v.commandT());
        //trin 14
        v.metoder(v.commandD("Placer netto på vægten"));
        //trin 15 - operatøren kvitterer
        v.metoder(v.commandRM20("Godkend", "OK"));
        //trin 16
        v.metoder(v.commandS());
        //trin 17
        v.metoder(v.commandT());
        //trin 18
        v.metoder(v.commandD("Fjern brutto fra vægten"));
        //trin 19 - operatøren kvitterer
        v.metoder(v.commandRM20("Godkend", "OK"));
        //trin 20
        v.metoder(v.commandS());
        //trin 21
        v.metoder(v.commandD("OK"));
        //trin 22 - operatøren kvitterer
        v.metoder(v.commandRM20("Godkend", "OK"));
        //trin 23
        v.metoder(v.commandT());
    }
}
