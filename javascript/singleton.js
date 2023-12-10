var Singleton = (function () {
    var instance;

    function Singleton() {
        // Private constructor to prevent instantiation outside the closure
    }

    Singleton.getInstance = function () {
        if (!instance) {
            instance = new Singleton();
        }
        return instance;
    };

    Singleton.prototype.someMethod = function () {
        console.log("Some method of the singleton");
    };

    return Singleton;
})();

// Usage
var singleton1 = Singleton.getInstance();
var singleton2 = Singleton.getInstance();

console.log(singleton1 === singleton2);  // Output: true

singleton1.someMethod();  // Output: Some method of the singleton
singleton2.someMethod();  // Output: Some method of the singleton
