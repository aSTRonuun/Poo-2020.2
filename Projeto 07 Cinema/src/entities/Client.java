package entities;

public class Client {
   
    private String id;
    private String fone;

    public Client(String id, String fone){
        this.id = id;
        this.fone = fone;
    }

    public String getFone() {
        return fone;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + ":" + fone;
    }
    
}
