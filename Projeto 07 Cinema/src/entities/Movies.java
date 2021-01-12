package entities;

import java.util.ArrayList;
import java.util.Collections;

public class Movies {
    
    private ArrayList<Client> clients;

    public Movies(int size){
        this.clients = new ArrayList<Client>(Collections.nCopies(size, null));
    }

    public boolean reserve(String id, String fone, int index){
        if(index > clients.size() || index < 0){
            System.out.println("Error: seat - " + index + " does not exist");
            return false;
        }
        if(clients.get(index) != null){
            System.out.println("Error: occupied seat");
            return false;
        }
        for(Client client : clients){
            if(client != null && client.getId().equals(id)){
                System.out.println("Error: this id already exist...try again");

                return false;
            }
        }
        Client c = new Client(id, fone);
        clients.set(index, c);
        return true;
    }

    public boolean cancel(String id){
        
        for(int i=0;i<clients.size();i++){
            if(clients.get(i) != null && clients.get(i).getId().equals(id)){
                clients.set(i, null);
                return true;
            }
        }
        System.out.println("Error: Id not found.");
        return false;
    }

    @Override
    public String toString() {
        String list = "["; 

        for(Client client : clients){
            if(client == null){
                list += " - ";
            }else{
                list += client.toString() + " ";
            }
        }

        list += "]";
        return list;
    }
}
