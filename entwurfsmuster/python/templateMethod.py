from abc import ABC, abstractmethod

# Abstract Class: CaffeineBeverage
class CaffeineBeverage(ABC):
    # Template Method
    def prepare_recipe(self):
        self.boil_water()
        self.brew()
        self.pour_in_cup()
        self.add_condiments()

    @abstractmethod
    def brew(self):
        pass

    @abstractmethod
    def add_condiments(self):
        pass

    def boil_water(self):
        print("Boiling water")

    def pour_in_cup(self):
        print("Pouring into cup")

# Concrete Class: Tea
class Tea(CaffeineBeverage):
    def brew(self):
        print("Steeping the tea")

    def add_condiments(self):
        print("Adding lemon")

# Concrete Class: Coffee
class Coffee(CaffeineBeverage):
    def brew(self):
        print("Dripping coffee through filter")

    def add_condiments(self):
        print("Adding sugar and milk")

# Client Code
def main():
    print("Making tea:")
    tea = Tea()
    tea.prepare_recipe()

    print("\nMaking coffee:")
    coffee = Coffee()
    coffee.prepare_recipe()

if __name__ == "__main__":
    main()
