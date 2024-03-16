export class Singleton {
    private static instance: Singleton | null = null;

    private constructor() {
        // Private constructor to prevent instantiation outside the class
    }

    public static getInstance(): Singleton {
        if (!Singleton.instance) {
            Singleton.instance = new Singleton();
        }
        return Singleton.instance;
    }

    public someMethod(): void {
        console.log("Some method of the singleton");
    }
}

// Usage
const singleton1 = Singleton.getInstance();
const singleton2 = Singleton.getInstance();

console.log(singleton1 === singleton2);  // Output: true

singleton1.someMethod();  // Output: Some method of the singleton
singleton2.someMethod();  // Output: Some method of the singleton
