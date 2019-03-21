import java.io.*;
import java.net.Socket;

public class VægtController {
    private Socket sock;
    private PrintWriter out;
    private BufferedReader in;

    public VægtController() throws Exception {
        sock = new Socket("127.0.0.1", 8000);
        System.out.println("Forbinder til vægt...");
        out = new PrintWriter(sock.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void metoder(String command) throws IOException {
        out.println(command);
        System.out.println(command);

        //out.flush();

        String inputFromWeight = in.readLine();
        System.out.println(inputFromWeight);

        System.out.println();
    }

    // Viser vægt i kg
    public String commandS(){
        return "S crlf";
    }

    // Tarerer vægten
    public String commandT(){
        return "T crlf";
    }

    // Skriver "output" i displayet
    public String commandD(String output){
        return "D " + "\"" + output + "\"" + " crlf";
    }

    // Viser vægten igen (bruges efter der er skrevet et output i displayet)
    public String commandDW(){
        return "DW crlf";
    }

    // Skriver "output" i et andet display
    public String commandP111(String output){
        if (output.length() <= 30)
            return "P111 " + "\"" + output + "\"" + " crlf";
        else
            return "FEJL, for langt output";
    }

    // Skriver "output" og "output2" i to displays og venter på inputs
    public String commandRM20(String output1, String output2){
        return "RM20 8 \"" + output1 + "\" \"" + output2 + "\" \"&3\"" + " crlf";
    }
}
