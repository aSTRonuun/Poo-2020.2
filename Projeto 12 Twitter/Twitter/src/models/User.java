package models;

import java.util.TreeMap;

public class User {
    
    private String userName;
    private TreeMap<String, User> followers;
    private TreeMap<String, User> following;
    //private TreeMap<Integer, Tweet> timeline;
    private int unreadCount;

    public User(String userName){
        this.userName = userName;
        this.followers = new TreeMap<>();
        this.following = new TreeMap<>();
        this.unreadCount = 0;
    }

    public void follow(User other){
        if(following.containsKey(other.userName))
            throw new RuntimeException("Error: you already follow this user: "+other.userName);
        following.put(other.userName, other);
        other.followers.put(this.userName, this);
    }

    public void unfollow(User other){
        if(!following.containsKey(other.userName))
            throw new RuntimeException("Error: you don't follow ther user: "+other.userName);
        following.remove(other.userName);
        other.followers.remove(this.userName);
    }

}
