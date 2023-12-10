public class Singleton {
    // Private static variable to hold the single instance
    private static Singleton instance;

    // Private constructor to prevent instantiation outside the class
    private Singleton() {
        // Initialization code, if needed
    }

    // Public static method to get the single instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and properties can be added here
    public void someMethod() {
        System.out.println("Some method of the singleton");
    }
}
