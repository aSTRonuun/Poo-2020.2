package controller;

import java.util.TreeMap;

import models.AccountBank;
import models.CheckingAccount;
import models.Client;
import models.SavingsAccount;

public class Agency {
    
    protected int nextToken;
    protected TreeMap<String, Client> clients;
    protected TreeMap<String, AccountBank> accounts;

    public Agency(){
        this.clients = new TreeMap<>();
        this.accounts = new TreeMap<>();
        this.nextToken = 0;
    }

    public void addClient(String userName){
        if(clients.containsKey(userName))
            throw new RuntimeException("❌ Error: user already registered in the system.");
        clients.put(userName, new Client(userName));
        SavingsAccount account01 = new SavingsAccount(this.nextToken, userName);this.nextToken ++;
        CheckingAccount account02 = new CheckingAccount(this.nextToken, userName);this.nextToken ++;
        clients.get(userName).getAccount().add(account01);
        clients.get(userName).getAccount().add(account02);
        accounts.put(userName, account01);
        accounts.put(userName, account02);
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for(AccountBank account : accounts.values())
            data.append(account.toString());
        return data.toString();
    }
}
