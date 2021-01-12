import entities.Pass;
import entities.Topic;

public class Aplication {

    public static void main(String[] args) {
        Topic topic = new Topic(5, 2);

        topic.toBoard(new Pass("davi", 17));
        topic.toBoard(new Pass("joao", 12));
        topic.toBoard(new Pass("vitor", 18));
        topic.toBoard(new Pass("ana", 31));
        topic.toBoard(new Pass("pedro", 45));
    }

}
