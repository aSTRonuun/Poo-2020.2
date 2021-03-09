import controller.Controller;
import models.Tweet;
import models.User;

public class App {
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.addUser("goku");
        controller.addUser("sara");
        controller.addUser("tina");
        System.out.println(controller);
        User one = controller.getUser("goku");
        User two = controller.getUser("sara");
        User tres = controller.getUser("tina");
        one.follow(two);
        one.follow(tres);
        two.follow(tres);
        System.out.println(controller);
        controller.sendTweet("sara", "hoje estou triste");
        controller.sendTweet("tina", "ganhei chocolate");
        controller.sendTweet("sara", "partiu ru");
        controller.sendTweet("tina", "chocolate ruim");
        controller.sendTweet("goku", "internet maldita");
        System.out.println(one.getTimeline());
        System.out.println(tres.getTimeline());
        System.out.println(two.getTimeline());
        two.getTweet(1).like("sara");
        one.getTweet(1).like("goku");
        two.getTweet(3).like("sara");
        System.out.println(two.getTimeline());
        System.out.println(one.getTimeline());
        one.unfollow(tres);
        System.out.println(controller);
    }
}
