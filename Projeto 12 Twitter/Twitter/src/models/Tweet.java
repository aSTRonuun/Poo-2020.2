package models;

import java.util.TreeSet;

public class Tweet {
    private int idTw;
    private String userName;
    private String msg;
    private TreeSet<String> likes;

    public Tweet(int idTw, String userName, String msg){
        this.idTw = idTw;
        this.userName = userName;
        this.msg = msg;
        this.likes = new TreeSet<>();
    }

    public void like(String userName){
        likes.add(userName);
    }

    public int getIdTw() {
        return idTw;
    }

    public String getUserName() {
        return userName;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append(this.idTw
            +":"
            +this.userName
            +"("
            +this.msg
            +")");
        if(likes.isEmpty())
            return data.toString();
         
        data.append("[👍-"+likes.size()+" ");
        for(String like : likes)
            data.append(like + ", ");
        data.append("]");
        return data.toString();
    }




}
