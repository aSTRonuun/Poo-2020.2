package controller;

import java.util.TreeMap;

import models.AccountBank;
import models.CheckingAccount;
import models.Client;
import models.SavingsAccount;

public class Agency {
    
    protected int nextToken;
    protected TreeMap<String, Client> clients;
    protected TreeMap<Integer, AccountBank> accounts;

    public Agency(){
        this.clients = new TreeMap<>();
        this.accounts = new TreeMap<>();
        this.nextToken = 0;
    }

    public void addClient(String userName){
        if(clients.containsKey(userName))
            throw new RuntimeException("❌ Error: user already registered in the system.");
        clients.put(userName, new Client(userName));
        CheckingAccount account02 = new CheckingAccount(this.nextToken, userName);this.nextToken ++;
        SavingsAccount account01 = new SavingsAccount(this.nextToken, userName);this.nextToken ++;
        clients.get(userName).getAccount().add(account01);
        clients.get(userName).getAccount().add(account02);
        accounts.put(account01.getId(), account01);
        accounts.put(account02.getId(), account02);
        return;
    }

    public void bankDeposit(int id, float value){
        if(!accounts.containsKey(id))
            throw new RuntimeException("❌ Error: Account id not found.");
        accounts.get(id).deposit(value);
        return;
    }

    public void bankDraft(int id, float value){
        if(!accounts.containsKey(id))
            throw new RuntimeException("❌ Error: Account id not found.");
        accounts.get(id).draft(value);
        return;
    }

    public void bankTransfer(int idMe,int idOther, float value){
        if(!accounts.containsKey(idMe) || !accounts.containsKey(idOther))
            throw new RuntimeException("❌ Error: Account id's not found.");
        accounts.get(idMe).transfer(accounts.get(idOther), value);
        return;
    }

    public void bankUpdate(){
        for(AccountBank account : accounts.values())
            account.monthlyUpdate();
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for(AccountBank account : accounts.values())
            data.append(account.toString()+"\n");
        return data.toString();
    }
}
