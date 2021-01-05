package entities;


import java.util.ArrayList;

public class AccountBank{

    private float balance;
    private int number;
    private ArrayList<Operation> extract;
    
    
    public AccountBank(int number){
        this.number = number;
        this.balance = 0;
        this.extract = new ArrayList<>();

        Operation op = new Operation("opening", 0, 0);
        this.extract.add(op);
    }

    public void getExtract(){
        System.out.println("-----------Extract-----------");
        for(Operation op : extract){
            System.out.println(extract.indexOf(op) + ": " +  op.toString());  
        }
        return;
    }

    public void getExtractLast(int n){
        System.out.println("-----------Extract from the " + n + " -----------");
        if(extract.size() > n){
            int last = extract.size() - n;
            for(Operation op : extract){
                if(extract.indexOf(op) >= last){
                    System.out.println(extract.indexOf(op) + ": " + op.toString());
                }
            }
        }else{
            getExtract();
        }
        return;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean deposit (float value){
        if(value < 0){
            System.out.println("Invalid value. Try again...");
            return false;
        }
        balance += value;
        System.out.println("Sucess!");
        Operation op = new Operation("deposit", value, balance);
        extract.add(op);
        return true;
    }

    public boolean toWithdraw(float value){
        if(value > 0){
            System.out.println("Invalid value. Trey again...");
            return false;
        }
        if(balance + value <= 0 || balance <= 0){
            System.out.println("There is not enough money!");
            return false;
        }
        balance += value;
        if(balance <= 0)
            balance = 0;
        System.out.println("Sucess!");
        Operation op = new Operation("Withdraw", value, balance);
        extract.add(op);
        return true;
    }

    @Override
    public String toString() {
        return "Account: " + number + " Balence: " + balance;
    }
}