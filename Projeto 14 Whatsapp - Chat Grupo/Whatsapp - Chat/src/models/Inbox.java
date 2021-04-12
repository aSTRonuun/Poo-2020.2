package models;

import java.util.ArrayList;

public class Inbox {
    public User user;
    public ArrayList<Message> newMessages;
    public ArrayList<Message> rep_messages;

    public Inbox(User user){
        this.user = user;
        this.newMessages = new ArrayList<>();
        this.rep_messages = new ArrayList<>(); 
    }

    public void addMsg(Message message){
        newMessages.add(message);
    }

    public ArrayList<Message> getMessages() {
        ArrayList<Message> messages = new ArrayList<>();
        for(Message message : this.newMessages){ 
            this.rep_messages.add(message);
            messages.add(message);
        }
        this.newMessages.clear();
        return messages;
    }

    public ArrayList<Message> getRep_messages() {
        return rep_messages;
    }

    public User getUser() {
        return user;
    }
}
