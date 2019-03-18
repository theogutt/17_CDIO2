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

    public String commandS(){
        return "S crlf";
    }

    public String commandT(){
        return "T crlf";
    }

    public String commandD(String output){
        return "D " + "\"" + output + "\"" + " crlf";
    }

    public String commandDW(){
        return "DW crlf";
    }

    public String commandP111(String output){
        if (output.length() <= 30)
            return "P111 " + "\"" + output + "\"" + " crlf";
        else
            return "FEJL, for langt output";
    }

    public String commandRM20(String output){
        return "RM20 8" + "\"" + "INDSKRIV NR" + "\"" + " \"\"" + " \"&3\" " + "crlf";
    }
}
