# Product: Pizza
class Pizza
    attr_accessor :crust, :sauce, :cheese, :toppings
  
    def initialize
      @crust = nil
      @sauce = nil
      @cheese = nil
      @toppings = []
    end
  
    def describe
      puts "Pizza: #{crust}, #{sauce}, #{cheese}, Toppings: #{toppings.join(', ')}"
    end
  end
  
  # Builder Interface
  class PizzaBuilder
    def build_crust
      raise NotImplementedError, "#{self.class} must implement build_crust"
    end
  
    def build_sauce
      raise NotImplementedError, "#{self.class} must implement build_sauce"
    end
  
    def build_cheese
      raise NotImplementedError, "#{self.class} must implement build_cheese"
    end
  
    def build_toppings
      raise NotImplementedError, "#{self.class} must implement build_toppings"
    end
  
    def pizza
      raise NotImplementedError, "#{self.class} must implement pizza"
    end
  end
  
  # Concrete Builder: MargheritaPizzaBuilder
  class MargheritaPizzaBuilder < PizzaBuilder
    def build_crust
      pizza.crust = "Thin Crust"
    end
  
    def build_sauce
      pizza.sauce = "Tomato Sauce"
    end
  
    def build_cheese
      pizza.cheese = "Mozzarella Cheese"
    end
  
    def build_toppings
      pizza.toppings = ["Tomatoes", "Basil"]
    end
  
    def pizza
      @pizza ||= Pizza.new
    end
  end
  
  # Director: PizzaDirector
  class PizzaDirector
    attr_reader :builder
  
    def initialize(builder)
      @builder = builder
    end
  
    def construct
      builder.build_crust
      builder.build_sauce
      builder.build_cheese
      builder.build_toppings
    end
  end
  
  # Client
  margherita_builder = MargheritaPizzaBuilder.new
  pizza_director = PizzaDirector.new(margherita_builder)
  pizza_director.construct
  margherita_pizza = margherita_builder.pizza
  margherita_pizza.describe
  