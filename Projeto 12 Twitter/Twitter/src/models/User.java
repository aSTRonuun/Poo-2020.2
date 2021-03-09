package models;

import java.util.ArrayList;
import java.util.TreeMap;

public class User {
    
    private String userName;
    private TreeMap<String, User> followers;
    private TreeMap<String, User> following;
    private TreeMap<Integer, Tweet> timeline;
    private ArrayList<Tweet> myTweets;
    private int unreadCount;

    public User(String userName){
        this.userName = userName;
        this.followers = new TreeMap<>();
        this.following = new TreeMap<>();
        this.timeline = new TreeMap<>();
        this.myTweets = new ArrayList<>();
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

    public void sendTweet(Tweet tweet){
        myTweets.add(tweet);
        timeline.put(tweet.getIdTw(), tweet);
        for(User follower: followers.values()){ 
            follower.timeline.put(tweet.getIdTw(), tweet);
            follower.unreadCount++;
        }
    }

    public Tweet getTweet(int idTw){
        if(!timeline.containsKey(idTw))
            throw new RuntimeException("Error: id not found... Try again!");
        return timeline.get(idTw);
    }

    public String getUnreadCount() {
        StringBuilder dataUnreadCount = new StringBuilder();
        dataUnreadCount.append(unreadCount + "new unread posts");
        return dataUnreadCount.toString();
    }

    public String getTimeline() {
        StringBuilder dataTimeline = new StringBuilder();
        for(Tweet tweet : timeline.values())
            dataTimeline.append(tweet.toString()+"\n");
        return dataTimeline.toString();
    }

    public String getUserName() {
        return userName;
    }

    public int getSizeFollowing(){
        return following.size();
    }

    public int getSizeFollowers(){
        return followers.size();
    }

    public TreeMap<String, User> getFollowers() {
        return followers;
    }

    public TreeMap<String, User> getFollowing() {
        return following;
    }
}
