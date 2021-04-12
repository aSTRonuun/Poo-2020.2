package models;

import java.util.ArrayList;
import java.util.TreeMap;

public class Chat {
    private String chatId;
    protected TreeMap<String, Inbox> inboxes;
    protected TreeMap<String, User> users;

    public Chat(String chatId){
        this.chatId = chatId;
        this.inboxes = new TreeMap<>();
        this.users = new TreeMap<>();
    }

    public String getChatId() {
        return chatId;
    }

    public ArrayList<Message> getMessages(String userId){
        if(!inboxes.containsKey(userId))
            throw new RuntimeException("❌ Error: user ("+userId+") not found!");
        ArrayList<Message> messages = inboxes.get(userId).getMessages();
        return messages;
    }

    public TreeMap<String, User> getUsers() {
        return users;
    }

    public void deliverZap(User userSend,String message){
        if(!users.containsKey(userSend.getUserId()))
            throw new RuntimeException("❌ Error: user ("+userSend+") user does not belong to the group's user list");

        Message msg = new Message(userSend.getUserId(), message);
        for(Inbox inbox : this.inboxes.values()){
            if(!inbox.getUser().equals(userSend))
                inbox.addMsg(msg);
        }
        for(User user : this.users.values()){
            if(!user.getUserId().equals(userSend.getUserId()))
                user.addNotify(this.chatId);
        }
    }

    public Inbox getInboxUser(User user){
        if(!this.users.containsKey(user.getUserId()))
            throw new RuntimeException("❌ Error: user ("+user.getUserId()+") not found!");
        return inboxes.get(user.getUserId());
    }

    public int unreadCount(String userId){
        if(!this.users.containsKey(userId))
            throw new RuntimeException("❌ Error: user ("+userId+") not found!");
        return users.get(userId).getNotifyUserChat(this.chatId).getUnreadCount();
    }

    public boolean hasUser(String userId){
        return this.users.containsKey(userId);
    }

    public void addUserChat(User user){
        if(users.containsKey(user.getUserId()))
            throw new RuntimeException("❌ Error: user ("+user.getUserId()+") is already added to the chat");
        users.put(user.getUserId(), user);
        inboxes.put(user.getUserId(), new Inbox(user));
    }

    public void addByInvite(User user, User invited){
        if(!users.containsKey(user.getUserId()))
            throw new RuntimeException("❌ Error: user ("+user.getUserId()+") is not in the group");
        if(users.containsKey(invited.getUserId()))
            throw new RuntimeException("❌ Error: user ("+user.getUserId()+") is already added to the chat");
        addUserChat(invited);
    }

    public void removeUserChat(User user){
        if(!users.containsKey(user.getUserId()))
            throw new RuntimeException("❌ Error: user ("+user.getUserId()+") not found!");
        users.remove(user.getUserId());
        inboxes.remove(user.getUserId());
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append(this.chatId+" ");
        return data.toString();
    }
}
