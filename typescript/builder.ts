// Product
class Pizza {
    size: string = "";
    cheese: boolean = false;
    pepperoni: boolean = false;
    mushrooms: boolean = false;

    toString(): string {
        return `Pizza: Size(${this.size}), Cheese(${this.cheese}), Pepperoni(${this.pepperoni}), Mushrooms(${this.mushrooms})`;
    }
}

// Builder Interface
abstract class PizzaBuilder {
    protected pizza: Pizza;

    constructor() {
        this.pizza = new Pizza();
    }

    abstract buildSize(): void;
    abstract buildCheese(): void;
    abstract buildPepperoni(): void;
    abstract buildMushrooms(): void;

    getResult(): Pizza {
        return this.pizza;
    }
}

// Concrete Builder
class MargheritaPizzaBuilder extends PizzaBuilder {
    buildSize(): void {
        this.pizza.size = "Medium";
    }

    buildCheese(): void {
        this.pizza.cheese = true;
    }

    buildPepperoni(): void {
        // Margherita pizza doesn't have pepperoni
    }

    buildMushrooms(): void {
        // Margherita pizza doesn't have mushrooms
    }
}

// Director
class PizzaDirector {
    private pizzaBuilder: PizzaBuilder;

    constructor(pizzaBuilder: PizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    constructPizza(): void {
        this.pizzaBuilder.buildSize();
        this.pizzaBuilder.buildCheese();
        this.pizzaBuilder.buildPepperoni();
        this.pizzaBuilder.buildMushrooms();
    }
}

// Client Code
const margheritaBuilder = new MargheritaPizzaBuilder();
const director = new PizzaDirector(margheritaBuilder);

director.constructPizza();
const margheritaPizza = margheritaBuilder.getResult();

console.log(margheritaPizza.toString());
