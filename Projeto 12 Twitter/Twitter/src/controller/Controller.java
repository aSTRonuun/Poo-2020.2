package controller;

import java.util.TreeMap;

import models.Tweet;
import models.User;

public class Controller {
    
    private TreeMap<String, User> users;
    private TreeMap<Integer, Tweet> tweets;
    private int nextTwId;

    public Controller(){
        this.users = new TreeMap<>();
        this.tweets = new TreeMap<>();
        this.nextTwId = 0;
    }

    public void addUser(String userName){
        if(users.containsKey(userName))
            throw new RuntimeException("Error: username already registered... choose another");
        users.put(userName, new User(userName));
    }

    public User getUser(String userName){
        if(users.containsKey(userName))
            return users.get(userName);
        throw new RuntimeException("Error: username not found.");
    }

    public void sendTweet(String userName, String msg){
        if(!users.containsKey(userName))
            throw new RuntimeException("Error: username not found.");
        Tweet tweet = new Tweet(this.nextTwId, userName, msg);
        users.get(userName).sendTweet(tweet);
        tweets.put(this.nextTwId, tweet);
        nextTwId++;
    }

    public String profileList(TreeMap<String, User> profiles){
        StringBuilder data = new StringBuilder();
        data.append("[");
        for(User profile : profiles.values())
            data.append(profile.getUserName() + " ");
        data.append("]\n");
        return data.toString();
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for(User user : users.values()){
            data.append(user.getUserName() + "\n");
            data.append("   following:" + user.getSizeFollowing()+ " ");
            data.append(" "+profileList(user.getFollowing()));
            data.append("   followers:" + user.getSizeFollowers()+ " ");
            data.append(" "+profileList(user.getFollowers()));
        }
        return data.toString();
    }

}
