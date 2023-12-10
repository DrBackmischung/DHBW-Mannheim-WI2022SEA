// Main class for client code
public class Main {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        AnimalFactory catFactory = new CatFactory();

        Animal dog = dogFactory.createAnimal();
        Animal cat = catFactory.createAnimal();

        System.out.println(dog.speak()); // Output: Woof!
        System.out.println(cat.speak()); // Output: Meow!
    }
}
