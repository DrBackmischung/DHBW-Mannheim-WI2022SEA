class MySingleton {
  // Private constructor
  MySingleton._();

  // Static instance variable
  static MySingleton? _instance;

  // Public method to get the singleton instance
  static MySingleton getInstance() {
    if (_instance == null) {
      _instance = MySingleton._();
    }
    return _instance!;
  }

  // Other methods or properties of the singleton
  void doSomething() {
    print("Singleton is doing something.");
  }
}

void main() {
  // Access the singleton instance
  var singleton1 = MySingleton.getInstance();
  var singleton2 = MySingleton.getInstance();

  // Check if both variables point to the same instance
  print("singleton1 and singleton2 are the same instance: ${identical(singleton1, singleton2)}");

  // Use the singleton
  singleton1.doSomething();
  singleton2.doSomething();
}
