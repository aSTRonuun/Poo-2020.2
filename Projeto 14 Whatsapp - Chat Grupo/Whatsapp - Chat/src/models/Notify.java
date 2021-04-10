package models;

public class Notify {
    public String chatId;
    public int unreadCount;
    
    public Notify(String chatId){
        this.chatId = chatId;
        this.unreadCount = 0;
    }

    public String getChatId() {
        return chatId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void addCount(){
        this.unreadCount++;
    }

    public void rmvNotify(){
        this.unreadCount--;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append(this.chatId+"("+this.unreadCount+")");
        return data.toString();
    }
}
