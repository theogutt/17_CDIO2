import java.io.*;
import java.net.Socket;

public class VægtController {
    private Socket sock;

    public VægtController() throws Exception {
        sock = new Socket("localhost", 8000);
        System.out.println("Forbinder til vægt...");
    }

    public void metoder(String command) throws IOException {
        OutputStream sos = sock.getOutputStream();
        PrintWriter pw = new PrintWriter(sos);
        InputStream is = sock.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        pw.println(command);
        System.out.println(command);
        pw.flush();
        String in = reader.readLine();
        System.out.println(in);
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
    public String commandRM20(String output, String output2){
        return "RM20 8" + "\"" + " " + output + "" + " \"\"" + " \"&OK" + "crlf";
    }
}
