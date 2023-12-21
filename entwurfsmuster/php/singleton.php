class Singleton {
    private static $instance;

    // Private constructor to prevent instantiation outside the class
    private function __construct() {
        // Initialization code, if needed
    }

    // Public static method to get the single instance
    public static function getInstance() {
        if (!isset(self::$instance)) {
            self::$instance = new self();
        }
        return self::$instance;
    }

    // Add other methods as needed
    public function someMethod() {
        echo "Some method of the singleton\n";
    }
}

// Usage
$singleton1 = Singleton::getInstance();
$singleton2 = Singleton::getInstance();

// Check if both instances are the same
var_dump($singleton1 === $singleton2); // Output: bool(true)

// Call a method on the singleton
$singleton1->someMethod(); // Output: Some method of the singleton
$singleton2->someMethod(); // Output: Some method of the singleton
