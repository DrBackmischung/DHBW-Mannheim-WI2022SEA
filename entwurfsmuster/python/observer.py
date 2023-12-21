class Subject:
    def __init__(self):
        self._observers = []

    def add_observer(self, observer):
        if observer not in self._observers:
            self._observers.append(observer)

    def remove_observer(self, observer):
        self._observers.remove(observer)

    def notify_observers(self, message):
        for observer in self._observers:
            observer.update(message)


class Observer:
    def update(self, message):
        pass


class ConcreteObserver(Observer):
    def __init__(self, name):
        self.name = name

    def update(self, message):
        print(f"{self.name} received message: {message}")


class ConcreteSubject(Subject):
    def set_state(self, state):
        print(f"Subject setting state to: {state}")
        self.notify_observers(f"State changed to {state}")


# Example usage
subject = ConcreteSubject()

observer1 = ConcreteObserver("Observer 1")
observer2 = ConcreteObserver("Observer 2")

subject.add_observer(observer1)
subject.add_observer(observer2)

subject.set_state("State1")
subject.set_state("State2")

subject.remove_observer(observer1)

subject.set_state("State3")
