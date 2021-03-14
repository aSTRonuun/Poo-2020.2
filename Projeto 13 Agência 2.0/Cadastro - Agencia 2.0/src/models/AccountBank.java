package models;

public class AccountBank{
    protected int id;
    protected float balance;
    protected String idClient;
    protected String type;

    public AccountBank(int id, String idClient){
        this.id = id;
        this.idClient = idClient;
        this.balance = 0;
    }

    public float getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public void draft(float value){
        if(this.balance <= 0)
            throw new RuntimeException("❌ Error: You have no available balance.");
        if(this.balance - value < 0)
            throw new RuntimeException("❌ Error: Insufficient balance to complete the action.");
        this.balance -= value;
        System.out.println("✅ Draft in the amount of "+value+" has been successfully made");
        return;
    }

    public void deposit(float value){
        this.balance += value;
        System.out.println("✅ Deposit in the amount of "+value+" has been successfully made");
        return;
    }

    public void transfer(AccountBank other, float value){
        if(this.balance <= 0)
            throw new RuntimeException("❌ Error: You have no available balance.");
        if(this.balance - value < 0)
            throw new RuntimeException("❌ Error: Insufficient balance to complete the action.");
        this.balance -= value;
        other.balance += value;
        System.out.println("✅ Transfer in the amount of "+value+" has been successfully made");
        return;
    }

    public void monthlyUpdate(){
        
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append(this.id
        +":"
        +this.idClient
        +":"
        +this.balance
        +":"
        +this.type);
        return data.toString();
    }
}