package entities;

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
        
        Contact contact = new Contact(name);
        contact = this.contacts.get(name);
        if(contact instanceof ContactPlus){
            ContactPlus contactPlus =  (ContactPlus) contact;
            contactPlus.setStarred(true);
            bookmarks.put(name, contactPlus);
        }
        throw new RuntimeException("Error");
        
    }
    public void unBookMark(String name){
        if(!this.bookmarks.containsKey(name))
            throw new RuntimeException("Contact "+ name +" does not exit.");
        
        bookmarks.remove(name);
    }
    public TreeMap<String, ContactPlus> getBookmarks() {
        return bookmarks;
    }
    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();
        for(ContactPlus bookmark : this.bookmarks.values())
            exit.append(bookmark.toString()+ "\n");
        return exit.toString();
    }
}
