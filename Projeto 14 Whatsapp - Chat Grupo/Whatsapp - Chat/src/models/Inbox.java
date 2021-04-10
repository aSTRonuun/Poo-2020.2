package models;

import java.util.ArrayList;

public class Inbox {
    public User user;
    public ArrayList<Message> messages;

    public Inbox(User user){
        this.user = user;
        this.messages = new ArrayList<>();
    }

    public void addMsg(Message message){
        messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public User getUser() {
        return user;
    }
}
