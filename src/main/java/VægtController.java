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

        System.out.println(in.readLine());

        System.out.println();
    }

    // Viser vægt i kg
    public void commandS() throws IOException {
        metoder("S crlf");
    }

    // Tarerer vægten
    public void commandT() throws IOException {
        metoder("T crlf");
    }

    // Skriver "output" i displayet
    public void commandD(String output) throws IOException {
        metoder("D " + "\"" + output + "\"" + " crlf");
    }

    // Viser vægten igen (bruges efter der er skrevet et output i displayet)
    public void commandDW() throws IOException {
        metoder("DW crlf");
    }

    // Skriver "output" i et andet display
    public void commandP111(String output) throws IOException {
        if (output.length() <= 30)
            metoder("P111 " + "\"" + output + "\"" + " crlf");
        else
            System.out.println("FEJL, for langt output");
    }

    // Skriver "output" og "output2" i to displays og venter på inputs
    public String commandRM20(String output1, String output2) throws IOException {
        metoder("RM20 8 \"" + output1 + "\" \"" + output2 + "\" \"&3\"" + " crlf");

        String input = in.readLine();
        System.out.println(input);

        return input;
    }
}
