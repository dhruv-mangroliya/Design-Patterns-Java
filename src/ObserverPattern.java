import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Subscriber {
    void notify(String msg);
}

// Concrete Observer
class User implements Subscriber {
    private int id;

    public User(int id) {
        this.id = id;
    }

    @Override
    public void notify(String msg) {
        System.out.println("Message received to user: " + id + " is -> " + msg + ".");
    }
}

// Subject
class Group {
    private List<Subscriber> subs = new ArrayList<>();

    public void subscribe(Subscriber sub) {
        subs.add(sub);
    }

    public void unsubscribe(Subscriber sub) {
        subs.remove(sub);
    }

    public void notifySubscribers(String msg) {
        for (Subscriber sub : subs) {
            sub.notify(msg);
        }
    }
}

// Client
public class ObserverPattern {
    public static void main(String[] args) {
        Group group = new Group();

        Subscriber u1 = new User(1);
        Subscriber u2 = new User(2);
        Subscriber u3 = new User(3);

        group.subscribe(u1);
        group.subscribe(u2);
        group.subscribe(u3);

        group.notifySubscribers("Hello Subscribers!");

        group.unsubscribe(u2);

        group.notifySubscribers("Second message after removing user 2");
    }
}
