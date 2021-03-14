package models;

public class CheckingAccount extends AccountBank {

    protected float monthlyFee;
    
    public CheckingAccount(int id, String idClient){
        super(id, idClient);
        this.monthlyFee = 20;
        this.type = "CC";
    }

    public void monthlyUpdate(){
        this.balance -= monthlyFee;
    }
}
