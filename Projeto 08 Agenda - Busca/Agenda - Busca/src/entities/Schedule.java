package entities;

import java.util.ArrayList;
import java.util.Collections;

public class Schedule {
    
    private ArrayList<Contact> contacts;

    public Schedule(){
        this.contacts = new ArrayList<>();
    }

    public boolean addContact(String name, ArrayList<Phone> phones){
        for(Contact contact : contacts){
            if(contact.getName().equals(name)){
                System.out.println("Name already redistered!");
                return false;
            }
        }
        this.contacts.add(new Contact(name, phones));
        Collections.sort(contacts);
        return true;
    }

    @Override
    public String toString() {
        String exit = "";

        for(Contact contact : contacts)
            exit += "- " + contact.toString() + "\n" ;

        return exit;
    }
}

