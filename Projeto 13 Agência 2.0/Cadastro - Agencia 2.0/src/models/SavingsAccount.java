package models;

public class SavingsAccount extends AccountBank {
    
    protected float yield;

    public SavingsAccount(int id, String idClient){
        super(id, idClient);
        this.yield = 1;
        this.type = "CP";
    }

    public void monthlyUpdate(){
        this.balance += balance * (yield/100); 
    }
}
