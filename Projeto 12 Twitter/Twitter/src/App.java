import models.User;

public class App {
    
    public static void main(String[] args) {
        User user = new User("vitor");
        User user1 = new User("adriele");
        user.follow(user1);
        user1.follow(user);
        user.unfollow(user1);
        user1.unfollow(user);
    }
}
