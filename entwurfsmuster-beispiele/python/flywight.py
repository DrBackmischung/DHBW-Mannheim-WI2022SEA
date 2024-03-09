# Flyweight Factory
class FlyweightFactory:
    _flyweights = {}

    @classmethod
    def get_flyweight(cls, key):
        if key not in cls._flyweights:
            cls._flyweights[key] = ConcreteFlyweight(key)
        return cls._flyweights[key]

    @classmethod
    def get_flyweights_count(cls):
        return len(cls._flyweights)


# Flyweight interface
class Flyweight:
    def operation(self, extrinsic_state):
        pass


# Concrete Flyweight
class ConcreteFlyweight(Flyweight):
    def __init__(self, intrinsic_state):
        self._intrinsic_state = intrinsic_state

    def operation(self, extrinsic_state):
        print(f"Concrete Flyweight with Intrinsic State: {self._intrinsic_state}, Extrinsic State: {extrinsic_state}")


# Client
def main():
    factory = FlyweightFactory()

    flyweight_1 = factory.get_flyweight("shared_state_1")
    flyweight_2 = factory.get_flyweight("shared_state_2")
    flyweight_3 = factory.get_flyweight("shared_state_1")  # Reusing existing flyweight

    flyweight_1.operation("non_shared_state_1")
    flyweight_2.operation("non_shared_state_2")
    flyweight_3.operation("non_shared_state_3")

    print(f"Total number of flyweights created: {factory.get_flyweights_count()}")


if __name__ == "__main__":
    main()
