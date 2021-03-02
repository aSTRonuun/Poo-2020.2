import models.Tweet;
import models.User;

public class App {
    
    public static void main(String[] args) {
        User user = new User("vitor");
        User user1 = new User("adriele");
        user.follow(user1);
        user1.follow(user);
        user.sendTweet(new Tweet(0, user.getUserName(), "eu vou conseguir fazer isso"));
        user.getTweet(0).like(user.getUserName());
        user1.getTweet(0).like(user1.getUserName());
        System.out.println(user.getTimeline());
        System.out.println(user1.getTimeline());
    }
}
