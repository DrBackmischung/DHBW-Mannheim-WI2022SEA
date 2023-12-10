# Komponente
interface Coffee {
    cost(): number;
    description(): string;
}

# Konkrete Komponente
class SimpleCoffee implements Coffee {
    cost(): number {
        return 5;
    }

    description(): string {
        return "Simple Coffee";
    }
}

# Dekorator
abstract class CoffeeDecorator implements Coffee {
    protected coffee: Coffee;

    constructor(coffee: Coffee) {
        this.coffee = coffee;
    }

    cost(): number {
        return this.coffee.cost();
    }

    description(): string {
        return this.coffee.description();
    }
}

# Konkreter Dekorator
class MilkDecorator extends CoffeeDecorator {
    cost(): number {
        return this.coffee.cost() + 2;
    }

    description(): string {
        return this.coffee.description() + ", Milk";
    }
}

# Beispielanwendung
let coffee: Coffee = new SimpleCoffee();
console.log(coffee.description(), "Cost:", coffee.cost());

let milkCoffee: Coffee = new MilkDecorator(coffee);
console.log(milkCoffee.description(), "Cost:", milkCoffee.cost());
