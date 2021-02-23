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
    /*
        Error por causa do diagrama:  
            Não consegui corrigir o addContact, pois, acabei me esquecendo estou esperando o vídeo para corrigir aqui.
        Gambiarra para add
            verifica-se se o contato existir
                se sim: adiciona apenas os phones no contato
                se não: cria-se um contato novo e adicionar os phones. 
    */
    public void addContact(String name, ArrayList<Phone> phones){
        boolean contains = true;
        if(this.contacts.containsKey(name)){
            this.contacts.get(name).addPhones(phones);
            contains = false;
        }
        if(contains){
            Contact addContact = new Contact(name);
            addContact.addPhones(phones);
            this.contacts.put(name, addContact);
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
            exit.append(contact.toString());
        return exit.toString();
    }
}
