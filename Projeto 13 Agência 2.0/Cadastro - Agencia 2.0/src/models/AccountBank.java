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

    public void toWithdraw(float value){
        if(this.balance <= 0)
            throw new RuntimeException("You have no available balance.");
        if(this.balance - value < 0)
            throw new RuntimeException("Insufficient balance to complete the action.");
        this.balance -= value;
        return;
    }

    public void deposit(float value){
        this.balance += value;
        System.out.println("✅ Operation performed successfully");
        return;
    }

    public void transfer(AccountBank other, float value){
        if(this.balance <= 0)
            throw new RuntimeException("You have no available balance.");
        if(this.balance - value < 0)
            throw new RuntimeException("Insufficient balance to complete the action.");
        this.balance -= value;
        other.balance += value;
        System.out.println("✅ Operation performed successfully");
        return;
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