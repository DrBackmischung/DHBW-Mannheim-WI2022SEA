// Product
class Pizza {
    constructor() {
        this.size = "";
        this.cheese = false;
        this.pepperoni = false;
        this.mushrooms = false;
    }

    toString() {
        return `Pizza: Size(${this.size}), Cheese(${this.cheese}), Pepperoni(${this.pepperoni}), Mushrooms(${this.mushrooms})`;
    }
}

// Builder Interface
class PizzaBuilder {
    constructor() {
        this.pizza = new Pizza();
    }

    buildSize() {}

    buildCheese() {}

    buildPepperoni() {}

    buildMushrooms() {}

    getResult() {
        return this.pizza;
    }
}

// Concrete Builder
class MargheritaPizzaBuilder extends PizzaBuilder {
    buildSize() {
        this.pizza.size = "Medium";
    }

    buildCheese() {
        this.pizza.cheese = true;
    }

    buildPepperoni() {
        // Margherita pizza doesn't have pepperoni
    }

    buildMushrooms() {
        // Margherita pizza doesn't have mushrooms
    }
}

// Director
class PizzaDirector {
    constructor(pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    constructPizza() {
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
