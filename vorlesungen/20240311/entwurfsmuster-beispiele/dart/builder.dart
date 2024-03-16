// Product: Pizza
class Pizza {
  String crust;
  String sauce;
  String cheese;
  List<String> toppings;

  Pizza() {
    crust = '';
    sauce = '';
    cheese = '';
    toppings = [];
  }

  void describe() {
    print('Pizza: $crust, $sauce, $cheese, Toppings: ${toppings.join(', ')}');
  }
}

// Builder Interface
abstract class PizzaBuilder {
  void buildCrust();
  void buildSauce();
  void buildCheese();
  void buildToppings();
  Pizza getPizza();
}

// Concrete Builder: MargheritaPizzaBuilder
class MargheritaPizzaBuilder implements PizzaBuilder {
  Pizza _pizza = Pizza();

  @override
  void buildCrust() {
    _pizza.crust = 'Thin Crust';
  }

  @override
  void buildSauce() {
    _pizza.sauce = 'Tomato Sauce';
  }

  @override
  void buildCheese() {
    _pizza.cheese = 'Mozzarella Cheese';
  }

  @override
  void buildToppings() {
    _pizza.toppings = ['Tomatoes', 'Basil'];
  }

  @override
  Pizza getPizza() {
    return _pizza;
  }
}

// Director: PizzaDirector
class PizzaDirector {
  PizzaBuilder builder;

  PizzaDirector(this.builder);

  void construct() {
    builder.buildCrust();
    builder.buildSauce();
    builder.buildCheese();
    builder.buildToppings();
  }
}

// Client
void main() {
  var margheritaBuilder = MargheritaPizzaBuilder();
  var pizzaDirector = PizzaDirector(margheritaBuilder);
  
  pizzaDirector.construct();
  var margheritaPizza = margheritaBuilder.getPizza();
  
  margheritaPizza.describe();
}
