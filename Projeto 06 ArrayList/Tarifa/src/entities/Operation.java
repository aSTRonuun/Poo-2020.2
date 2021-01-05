package entities;

public class Operation {
    
    private String descricao;
    private float value;
    private float balance;

    public Operation(){
        
    }

    public Operation(String descricao, float value, float balance){
        this.descricao = descricao;
        this.value = value;
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return descricao + ": " + value + ": " + balance;
    }
    

}
