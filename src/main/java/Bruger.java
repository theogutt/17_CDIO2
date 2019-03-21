public class Bruger {
    private int brugerId;
    private String navn;

    public Bruger(int brugerId, String navn){
        this.brugerId = brugerId;
        this.navn = navn;
    }

    public int getBrugerId(){
        return brugerId;
    }

    public void setBrugerId(int brugerId){
        this.brugerId = brugerId;
    }

    public String getNavn(){
        return navn;
    }

    public void setNavn(String navn){
        this.navn = navn;
    }
}
