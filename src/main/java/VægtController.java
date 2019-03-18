import java.io.*;
import java.net.Socket;

public class VægtController {
    public VægtController() throws Exception {
        forbind();
    }
    public void forbind() throws Exception {
        Socket sock = new Socket("localhost", 8000);
        System.out.println("Forbinder til vægt...");
        OutputStream sos = sock.getOutputStream();
        PrintWriter pw = new PrintWriter(sos);
        InputStream is = sock.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String command = "S crlf";
        pw.println(command);
        System.out.println(command);
        pw.flush();
        String in = reader.readLine();
        System.out.println(in);
    }
}
