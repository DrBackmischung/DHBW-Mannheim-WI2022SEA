// Factory
abstract class Animal {
    abstract speak(): String;
    abstract eat(): String;
}

// Factory
abstract class Car {
    abstract drive(): String;
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

// Squirrel
class Squirrel extends Animal {
    speak(): String {
        return 'Miep miep miep'
    }
    eat(): String {
        return 'gar nichts, es versteckt ja essen'
    }
}

// Squirrel
class PorscheCayene extends Car {
    drive(): String {
        return "brumm brumm";
    }
}

export class CatFactory {
    private static instance: CatFactory | null = null;
    private static CatFactory () {}

    public static getInstance(): CatFactory {
        if(!CatFactory.instance) {
            CatFactory.instance = new CatFactory();
        }
        return CatFactory.instance;
    }

    create(): Cat {
        return new Cat();
    }
}

export class SquirrelFactory {
    create(): Squirrel {
        return new Squirrel();
    }
}

export class PorscheCayeneFactory {
    create(): PorscheCayene {
        return new PorscheCayene();
    }
}