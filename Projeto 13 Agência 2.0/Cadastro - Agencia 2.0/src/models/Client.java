package models;

import java.util.ArrayList;

public class Client{

    protected String userName;
    protected ArrayList<AccountBank> account;

    public Client(String userName){
        this.userName = userName;
        this.account = new ArrayList<>();
    }

    public ArrayList<AccountBank> getAccount() {
        return account;
    }
}