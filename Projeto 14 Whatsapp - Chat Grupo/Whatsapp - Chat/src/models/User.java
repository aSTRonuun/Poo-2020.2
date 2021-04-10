package models;

import java.util.TreeMap;

public class User {
    private String userId;
    protected TreeMap<String, Chat> chats;
    protected TreeMap<String, Notify> notify;

    public User(String userId){
        this.userId = userId;
        this.chats = new TreeMap<>();
        this.notify = new TreeMap<>();
    }

    public String getUserId() {
        return userId;
    }

    public TreeMap<String, Chat> getChats() {
        return chats;
    }

    public TreeMap<String, Notify> getNotify() {
        return notify;
    }

    public Notify getNotifyUserChat(String chat){
        if(!this.notify.containsKey(chat))
            throw new RuntimeException("❌ Error:  chat ("+chat+") not found.");
        return this.notify.get(chat);
    }

    public void addChat(Chat chat){
        if(chats.containsKey(chat.getChatId()))
            throw new RuntimeException("❌ Error: the user is already added to the chat ("+chat.getChatId()+").");
        chats.put(chat.getChatId(), chat);
        notify.put(chat.getChatId(), new Notify(chat.getChatId()));
    }

    public void addNotify(String chatId){
        if(!notify.containsKey(chatId))
            throw new RuntimeException("❌ Error:  chat ("+chatId+") not found.");
        notify.get(chatId).addCount();
    }

    public void removeChat(Chat chat){
        if(!chats.containsKey(chat.getChatId()))
            throw new RuntimeException("❌ Error: chat ("+chat.getChatId()+") not found.");
        chats.remove(chat.getChatId());
        notify.remove(chat.getChatId());
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append("["+this.userId+"]");
        return data.toString();
    }
}
