// Singleton class
class Singleton {
    // Volatile ensures visibility across threads
    private static volatile Singleton instance = null;
    private static int counter = 0;

    // Private constructor to prevent instantiation
    private Singleton() {
        counter++;
        System.out.println("Instance count: " + counter);
    }

    // Double-checked locking for thread safety + lazy initialization
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }
}

// Client code
public class SingletonPattern {
    public static void main(String[] args) {
        // Only one instance is created
        Singleton s1 = Singleton.getInstance();
        s1.log("First call to singleton");

        Singleton s2 = Singleton.getInstance();
        s2.log("Second call to singleton");

        System.out.println("Are s1 and s2 same? " + (s1 == s2));
    }
}
