import java.io.*;
import java.net.Socket;

public class VægtController {
    public VægtController() throws Exception {
        forbind();
    }
    public void forbind() throws Exception {
        Socket sock = new Socket("localhost", 8000);
        System.out.println("Forbinder til vægt...");
        InputStream is = sock.getInputStream();
        modtag(is);
        sock.close();
        System.out.println("Forbindelsen er afsluttet");
    }
    public void modtag(InputStream is) throws Exception {

    }
}
