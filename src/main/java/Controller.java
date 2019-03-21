import java.io.IOException;

public class Controller {
    private WeightConnector v;
    private User user;
    private Batch batch;


    public Controller() throws Exception {
        user = new User(12, "Anders And");
        batch = new Batch(1234, "Salt");
        v = new WeightConnector();
    }

    /*
    public void commandMenu() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMenu\n 1. Vis vægt\n 2. Tara vægt\n 3.skriver ord i veje display\n 4.retunerer til vægt visning\n 5. plads til 30 karakterer\n 6.Skriver INDTAST NR " +
                "Afventer indtastning (her 123)som så retunerer: RM20 A ”123” crlf \n");
        int valg = sc.nextInt();
        if(valg==1){v.callWeight(v.commandS());}
        else if(valg==2){v.callWeight(v.commandT());}
        else if(valg==3){v.callWeight(v.commandD(output()));}
        else if(valg==4){v.callWeight(v.commandDW());}
        else if(valg==5){v.callWeight(v.commandP111(output()));}
        else if(valg==6){v.callWeight(v.commandRM20(output(), output()));}
    }


    public String output(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indtast ord: ");
        String output = sc.next();
        return output;
    }
    */

    public void testProcedure() throws IOException {
        String userInput;
        // Trin 1: Vægten beder om, at der indtastes operatørnummer
        // Trin 2: Operatøren indtaster sit brugernummer (område 11-99)
        do {
            do {
                userInput = v.commandRM20("INDTAST OPERATØRNUMMER", "11-99");
            } while (!inputEquals(userInput, 12));

            // Trin 3 & 4: Operatørens navn findes i databasen og vises på vægten
            userInput = v.commandRM20(user.getName(), "Er dette dit navn? y/n");
        } while(!inputEquals(userInput, "Y"));

        // Trin 5 & 6: Vægten beder om, at der indtastes batch nummer (område 1000-9999)
        do {
            userInput = v.commandRM20("INDTAST BATCH-NUMMER", "1000-9999");
        } while (!inputEquals(userInput, 1234));

        // Trin 7 & 8: Operatøren instrueres om, at vægten skal være ubelastet
        // Trin 9: Vægten tareres
        v.commandRM20("FJERN ALT FRA VÆGTEN", "Tryk OK");
        v.commandT();

        // Trin 10 & 11: Operatøren instrueres om, at placere tara (tom beholder)  på vægten
        v.commandRM20("PLACER TARA (TOM BEHOLDER)", "Tryk OK");

        // Trin 12: Tara’s vægt registreres
        v.commandS();

        // Trin 13: Vægten tareres
        v.commandT();

        // Trin 14 & 15: Operatøren instrueres i at placere netto (beholder med produkt)  på vægten
        v.commandRM20("PLACER NETTO PÅ VÆGT", "Tryk OK");

        // Trin 16: Nettovægt registreres
        v.commandS();

        // Trin 17: Vægten tareres
        v.commandT();

        // Trin 18 & 19: Operatøren instrueres i at fjerne brutto fra vægten
        v.commandRM20("Fjern brutto fra vægten", "Tryk OK");

        // Trin 20: Bruttovægt registreres (negativ)
        v.commandS();

        // Trin 22: Operatøren kvitterer
        v.commandRM20("Godkend", "OK");

        // Trin 23: Vægten tareres
        v.commandT();
    }

    private boolean inputEquals(String input, String match){
        return input.equalsIgnoreCase("RM20 A \"" + match +"\"");
    }

    private boolean inputEquals(String input, int match){
        return input.equalsIgnoreCase("RM20 A \"" + match +"\"");
    }
}
