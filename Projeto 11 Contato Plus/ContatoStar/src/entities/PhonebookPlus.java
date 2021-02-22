package entities;

import java.util.ArrayList;
import java.util.TreeMap;

public class PhonebookPlus extends Phonebook {
    private TreeMap<String, ContactPlus> bookmarks;

    public PhonebookPlus() {
        this.bookmarks = new TreeMap<>();
    }

    public boolean rmvContact(String name) {
        if (!this.contacts.containsKey(name) && !this.bookmarks.containsKey(name))
            throw new RuntimeException("Contact " + name + "does not exist.");          
              
        this.contacts.remove(name);
        this.bookmarks.remove(name);
        return true;
    }

    public void bookMark(String name) {
        if (!this.contacts.containsKey(name))
            throw new RuntimeException("Contact " + name + " does not exist.");
        if (this.bookmarks.containsKey(name))
            throw new RuntimeException("The contact " + name + " is already in the favorite list.");

        Contact addContact = this.contacts.get(name);
        ContactPlus addContactPlus = new ContactPlus(addContact.getName());
        ArrayList<Phone> phones = new ArrayList<>();
        phones = addContact.getPhones();
        addContactPlus.addPhones(phones);
        addContactPlus.setStarred(true);
        this.contacts.remove(name);
        this.bookmarks.put(name, addContactPlus);
        System.out.println("Contact "+ name +" added to favorites list.");
        return;
    }

    public void unBookMark(String name){
        if(!this.bookmarks.containsKey(name))
            throw new RuntimeException("Contact "+ name +" does not exit.");
        
        Contact addContact = this.bookmarks.get(name);
        this.contacts.put(name, addContact);
        this.bookmarks.get(name).setStarred(false);
        this.bookmarks.remove(name);
        System.out.println("Contact "+ name +" removed successfully in the favorite list");
    }

    public TreeMap<String, ContactPlus> getBookmarks() {
        return bookmarks;
    }

    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();
        for(ContactPlus bookmark : this.bookmarks.values())
            exit.append(bookmark.toString());
        for(Contact contact : this.contacts.values())
            exit.append(contact.toString());
        return exit.toString();
    }
}
