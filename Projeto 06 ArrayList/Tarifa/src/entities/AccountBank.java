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
        System.out.println("-----------------------------");
        return;
    }

    public void getExtractLast(int n){
        if(extract.size() > n){
            System.out.println("-----------Extract from the " + n + " -----------");
            int last = extract.size() - n;
            for(Operation op : extract){
                if(extract.indexOf(op) >= last){
                    System.out.println(extract.indexOf(op) + ": " + op.toString());
                }
            }
            System.out.println("---------------------------------------------");
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
        Operation op = new Operation("Deposit", value, balance);
        extract.add(op);
        return true;
    }

    public boolean toWithdraw(float value){
        if(value > 0){
            System.out.println("Invalid value. Trey again...");
            return false;
        }
        if(balance + value < 0 || balance < 0){
            System.out.println("There is not enough money!");
            return false;
        }
        balance += value;
        System.out.println("Sucess!");
        Operation op = new Operation("Withdraw", value, balance);
        extract.add(op);
        return true;
    }

    public boolean tariff(float value){
        if(value < 0){
            System.out.println("Invalid value. Trey again...");
            return false;
        }
        if(balance - value < 0){
            System.out.println("There is not enough money!");
            return false;
        }
        balance -= value;
        System.out.println("Sucess!");
        Operation op = new Operation("Tariff", -value, balance);
        extract.add(op);
        return true;
    }

    public boolean reversal(int[] indexs){
        for(int i=0;i<indexs.length;i++){
            boolean reverse = false;
            float value = 0;
            for(Operation op : extract){
                if(indexs[i] == extract.indexOf(op) && op.getDescricao().equals("Tariff")){
                    balance += op.getValue() * (-1);
                    value = op.getValue() * (-1);
                    reverse = true;
                }
                else if(indexs[i] == extract.indexOf(op) && !op.getDescricao().equals("Tariff")){
                    System.out.println("Index " + indexs[i] + " is not tariff");
                }
                else if(indexs[i] >= extract.size()){
                    System.out.println("Index " + indexs[i] + " is invalid");
                    indexs[i] = -1;
                }
            }
            if(reverse){
                Operation op = new Operation("Reverse", value, balance);
                extract.add(op);
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account: " + number + " Balence: " + balance;
    }
}