package controller;

import java.util.ArrayList;
import java.util.TreeMap;

import models.Chat;
import models.Message;
import models.User;

public class WhatsappService {
    private TreeMap<String, Chat> rep_chat;
    private TreeMap<String, User> rep_user;
    
    public WhatsappService(){
        this.rep_chat = new TreeMap<>();
        this.rep_user = new TreeMap<>();
    }

    protected User getUser(String userId){
        if(!this.rep_user.containsKey(userId))
            throw new RuntimeException("❌ Error: userName ("+userId+") not found in the system.");
        return this.rep_user.get(userId);   
    }

    protected Chat getChat(String chatId){
        if(!this.rep_chat.containsKey(chatId))
            throw new RuntimeException("❌ Error: chatId ("+chatId+") not found in the system.");
        return this.rep_chat.get(chatId);  
    }

    protected boolean hasUser(User user){
        return this.rep_user.containsKey(user.getUserId());
    }

    protected boolean hasChat(Chat chat){
        return this.rep_chat.containsKey(chat.getChatId());
    }

    public String getChatsUser(String userId){
        if(!this.rep_user.containsKey(userId))
            throw new RuntimeException("❌ Error: userName ("+userId+") not found in the system.");
        StringBuilder chatsData = new StringBuilder();
        chatsData.append(userId + ": (chats)"+"[");
        rep_user.get(userId).getChats().values().forEach((chat) -> chatsData.append(chat.getChatId()+" "));
        chatsData.append("]");
        return chatsData.toString();
    }

    public String getUsersChat(String chatId){
        if(!this.rep_chat.containsKey(chatId))
            throw new RuntimeException("❌ Error: chat ("+chatId+") not found in the system.");
        StringBuilder usersData = new StringBuilder();
        usersData.append(chatId + ": (users)"+"[");
        rep_chat.get(chatId).getUsers().values().forEach((user) -> usersData.append(user.getUserId()+" "));
        usersData.append("]");
        return usersData.toString();
    }

    public String getNotifyUser(String userId){
        if(!this.rep_user.containsKey(userId))
            throw new RuntimeException("❌ Error: userName ("+userId+") not found in the system.");  
        StringBuilder notifyData = new StringBuilder();
        notifyData.append("Notify "+ "[");
        rep_user.get(userId).getNotify().values().forEach(
            (notify) -> notifyData.append(notify.toString()+" "));
        notifyData.append("]");
        return notifyData.toString();
    }

    public void creatChat(String userId, String chatId){
        if(this.rep_chat.containsKey(chatId))
            throw new RuntimeException("❌ Error: chatId ("+chatId+") already registered in the system");

        User user = this.getUser(userId);
        Chat chat = new Chat(chatId);
        this.rep_chat.put(chatId, chat);
        user.addChat(chat);
        chat.addUserChat(user);
        return;
    }

    public void createUser(String userId){
        if(rep_user.containsKey(userId))
            throw new RuntimeException("❌ Error: userName ("+userId+") already registered in the system.");
        rep_user.put(userId, new User(userId));
        return;
    }

    public void addByInvite(String invitingId, String invitedId, String chatId){        
        User inviting = getUser(invitingId);
        User invited = getUser(invitedId);
        Chat chat = getChat(chatId);
        chat.addByInvite(inviting, invited);
        invited.addChat(chat);
        return;
    }

    public String allUsers(){
        StringBuilder allUsersData = new StringBuilder();
        this.rep_user.values().forEach((user) -> allUsersData.append(user.toString()+" "));
        return allUsersData.toString();
    }

    public void removeUserChat(String userId, String chatId){
        User user = getUser(userId);
        Chat chat = getChat(chatId);
        chat.removeUserChat(user);
        user.removeChat(chat);
        return;
    }

    public void sendMessage(String userIdSend, String chatId, String message){
        User userSend = getUser(userIdSend);
        Chat chat = getChat(chatId);
        chat.deliverZap(userSend, message);
        return;
    }

    public String readMessageUserChat(String userId, String chatId){
        User user = getUser(userId);
        Chat chat = getChat(chatId);
        StringBuilder readMessageData = new StringBuilder();
        readMessageData.append("Chat ("+chatId+"):\n");
        ArrayList<Message> newMessages = chat.getMessages(userId);
        for(Message message : newMessages)
            readMessageData.append(message+"\n");
        user.getNotifyUserChat(chatId).rmvNotify();
        return readMessageData.toString();
    }
}
