public class VægtController {



    public VægtController(){
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
