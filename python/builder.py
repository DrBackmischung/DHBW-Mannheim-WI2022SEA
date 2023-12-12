# Product
class Pizza:
    def __init__(self):
        self.size = ""
        self.cheese = False
        self.pepperoni = False
        self.mushrooms = False

    def __str__(self):
        return f"Pizza: Size({self.size}), Cheese({self.cheese}), Pepperoni({self.pepperoni}), Mushrooms({self.mushrooms})"


# Abstract Builder
class PizzaBuilder:
    def __init__(self):
        self.pizza = Pizza()

    def build_size(self):
        pass

    def build_cheese(self):
        pass

    def build_pepperoni(self):
        pass

    def build_mushrooms(self):
        pass

    def get_result(self):
        return self.pizza


# Concrete Builder
class MargheritaPizzaBuilder(PizzaBuilder):
    def build_size(self):
        self.pizza.size = "Medium"

    def build_cheese(self):
        self.pizza.cheese = True

    def build_pepperoni(self):
        pass

    def build_mushrooms(self):
        pass


# Director
class PizzaDirector:
    def __init__(self, pizza_builder):
        self.pizza_builder = pizza_builder

    def construct_pizza(self):
        self.pizza_builder.build_size()
        self.pizza_builder.build_cheese()
        self.pizza_builder.build_pepperoni()
        self.pizza_builder.build_mushrooms()


# Client code
if __name__ == "__main__":
    margherita_builder = MargheritaPizzaBuilder()
    director = PizzaDirector(margherita_builder)

    director.construct_pizza()
    margherita_pizza = margherita_builder.get_result()

    print(margherita_pizza)
