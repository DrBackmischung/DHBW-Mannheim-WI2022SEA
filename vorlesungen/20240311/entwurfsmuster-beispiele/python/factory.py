# Product interface
class Animal:
    def speak(self):
        pass

# Concrete Products
class Dog(Animal):
    def speak(self):
        return "Woof!"

class Cat(Animal):
    def speak(self):
        return "Meow!"

# Factory
class AnimalFactory:
    def create_animal(self, animal_type):
        if animal_type.lower() == 'dog':
            return Dog()
        elif animal_type.lower() == 'cat':
            return Cat()
        else:
            raise ValueError("Invalid animal type")

# Client code
factory = AnimalFactory()

dog = factory.create_animal('dog')
cat = factory.create_animal('cat')

print(dog.speak())  # Output: Woof!
print(cat.speak())  # Output: Meow!
