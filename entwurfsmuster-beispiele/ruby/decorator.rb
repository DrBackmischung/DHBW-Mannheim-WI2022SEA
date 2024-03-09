# Component: Pizza
class Pizza
    def description
      'Plain Pizza'
    end
  
    def cost
      10.0
    end
  end
  
  # Decorator: ToppingDecorator
  class ToppingDecorator
    attr_reader :pizza
  
    def initialize(pizza)
      @pizza = pizza
    end
  
    def description
      pizza.description
    end
  
    def cost
      pizza.cost
    end
  end
  
  # Concrete Decorator: TomatoTopping
  class TomatoTopping < ToppingDecorator
    def description
      "#{pizza.description}, Tomato"
    end
  
    def cost
      pizza.cost + 2.0
    end
  end
  
  # Concrete Decorator: BasilTopping
  class BasilTopping < ToppingDecorator
    def description
      "#{pizza.description}, Basil"
    end
  
    def cost
      pizza.cost + 1.5
    end
  end
  
  # Client
  pizza = Pizza.new
  puts "Plain Pizza: #{pizza.description}, Cost: $#{pizza.cost}"
  
  tomato_pizza = TomatoTopping.new(pizza)
  puts "Pizza with Tomato: #{tomato_pizza.description}, Cost: $#{tomato_pizza.cost}"
  
  basil_tomato_pizza = BasilTopping.new(tomato_pizza)
  puts "Pizza with Tomato and Basil: #{basil_tomato_pizza.description}, Cost: $#{basil_tomato_pizza.cost}"
  