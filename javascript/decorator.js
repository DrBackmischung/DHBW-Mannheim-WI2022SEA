// Component interface
class Coffee {
    cost() {
      return 5;
    }
  
    description() {
      return 'Simple Coffee';
    }
  }
  
  // Decorator interface
  class CoffeeDecorator {
    constructor(coffee) {
      this.coffee = coffee;
    }
  
    cost() {
      return this.coffee.cost();
    }
  
    description() {
      return this.coffee.description();
    }
  }
  
  // Concrete Component
  class SimpleCoffee extends Coffee {}
  
  // Concrete Decorator
  class MilkDecorator extends CoffeeDecorator {
    cost() {
      return this.coffee.cost() + 2;
    }
  
    description() {
      return this.coffee.description() + ', Milk';
    }
  }
  
  // Example application
  const simpleCoffee = new SimpleCoffee();
  
  console.log(simpleCoffee.description(), 'Cost:', simpleCoffee.cost());
  
  const milkCoffee = new MilkDecorator(simpleCoffee);
  
  console.log(milkCoffee.description(), 'Cost:', milkCoffee.cost());
  