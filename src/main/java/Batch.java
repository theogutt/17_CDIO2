public class Batch {

    private int batchID;
    private String batchName;

    public Batch(int batchID, String batchName){
        this.batchID = batchID;
        this.batchName = batchName;
    }

    public int getBatchID(){
        return this.batchID;
    }

    public String getBatchName(){
        return this.batchName;
    }

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
}
