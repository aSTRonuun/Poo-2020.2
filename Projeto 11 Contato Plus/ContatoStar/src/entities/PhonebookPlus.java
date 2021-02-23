package entities;

import java.util.ArrayList;
import java.util.TreeMap;

public class PhonebookPlus extends Phonebook {
    private TreeMap<String, ContactPlus> bookmarks;

    public PhonebookPlus() {
        this.bookmarks = new TreeMap<>();
    }
    /*
        Gambiarra para remover:  
            verifica-se se o contato existe na lista de contatos e na lista de favoritos
                se não tiver: error
            Se tive tudo ok
                adiciona o contato que era da lista de contato para a lista de favoritos
                remove o contato da lista de favoritos
    */


    public boolean rmvContact(String name) {
        if (!this.contacts.containsKey(name) && !this.bookmarks.containsKey(name))
            throw new RuntimeException("Contact " + name + "does not exist.");          
              
        this.contacts.remove(name);
        this.bookmarks.remove(name);
        return true;
    }
    /*
        Gambiarra para favoritar:  
            verifica-se se o contato está na lista de contato
                se não: erro
            verifica-se se o contato já está lista de favoritos
                se sim: erro
            Se tive tudo ok
                adiciona o contato que era da lista de contato para a lista de favoritos
                remove o contato da lista de favoritos
    */
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
    /*
        Gambiarra para desfavotirar:  
            verifica-se se o contato já está lista de favoritos
                se nao: erro
            Se tive tudo ok
                remove o contato da lista de favoritos e adiciona ele de volta para a lista de contatos
    */
    public void unBookMark(String name){
        if(!this.bookmarks.containsKey(name))
            throw new RuntimeException("Contact "+ name +" does not exit.");
        
        Contact addContact = this.bookmarks.get(name);
        this.contacts.put(name, addContact);
        this.bookmarks.get(name).setStarred(false);
        this.bookmarks.remove(name);
        System.out.println("Contact "+ name +" removed successfully in the favorite list");
    }
    public String showBookmark(){
        StringBuilder exit = new StringBuilder();
        for(ContactPlus bookmark : this.bookmarks.values())
            exit.append(bookmark.toString());
        return exit.toString();
    }

    public TreeMap<String, ContactPlus> getBookmarks() {
        return bookmarks;
    }
    /*
        Gambiarra para imprimir:  
            primeiro imprime a lista de favoritos e depois imprime a lista de contatos normais.
    */
    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();
        for(ContactPlus bookmark : this.bookmarks.values())
            exit.append(bookmark.toString()+ "\n");
        for(Contact contact : this.contacts.values())
            exit.append(contact.toString()+ "\n");
        return exit.toString();
    }
}
