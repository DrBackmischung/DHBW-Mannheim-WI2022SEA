public class Main {
    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Check if both instances are the same
        System.out.println(singleton1 == singleton2);  // Output: true

        // Call a method on the singleton
        singleton1.someMethod();  // Output: Some method of the singleton
        singleton2.someMethod();  // Output: Some method of the singleton
    }
}
