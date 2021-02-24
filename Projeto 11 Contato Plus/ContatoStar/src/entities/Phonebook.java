package entities;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phonebook {
    protected TreeMap<String, Contact> contacts;

    public Phonebook(){
        this.contacts = new TreeMap<>();
    }

    public void addContact(Contact contact){
        boolean contains = true;
        if(this.contacts.containsKey(contact.getName())){
            this.contacts.get(contact.name).addPhones(contact.getPhones());
            contains = false;
        }
        if(contains){
            this.contacts.put(contact.getName(), contact);
            System.out.println("Contact added sucessefully.");
        }
        return;
    }

    public boolean rmvContact(String name){
        if(this.contacts.containsKey(name)){
            throw new RuntimeException("Name not found.");
        }
        this.contacts.remove(name);
        System.out.println("Contact removed from contact list.");
        return true;
    }

    public ArrayList<Contact> search(String expression){
        ArrayList<Contact> regexContact = new ArrayList<>();

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher;
        for(Contact contact : this.contacts.values()){
            matcher = pattern.matcher(contact.toString());
            if(matcher.find())
                regexContact.add(contact);
        }

        return regexContact;
    }

    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();
        for(Contact contact : this.contacts.values())
            exit.append(contact.toString() + "\n");
        return exit.toString();
    }
}
