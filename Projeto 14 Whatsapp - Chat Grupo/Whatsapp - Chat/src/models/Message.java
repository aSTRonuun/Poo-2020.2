package models;

public class Message {
    
    public String userId;
    public String text;

    public Message(String userId, String text){
        this.userId = userId;
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append("["+ userId+":"+text+"]");
        return data.toString();
    }
}
