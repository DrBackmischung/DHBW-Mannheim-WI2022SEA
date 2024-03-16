// Interface
abstract class Animal {
    abstract speak(): String;
    abstract eat(): String;
}

// Cat
class Cat extends Animal {
    speak(): String {
        return 'Meow'
    }
    eat(): String {
        return 'Nom nom nom'
    }
}

// Dog
class Dog extends Animal {
    speak(): String {
        return 'Woof'
    }
    eat(): String {
        return 'Chomp chomp'
    }
}

// Cat Factory
export class CatFactory {
    create(): Cat {
        return new Cat();
    }
}

// Dog Factory
export class DogFactory {
    create(): Dog {
        return new Dog();
    }
}