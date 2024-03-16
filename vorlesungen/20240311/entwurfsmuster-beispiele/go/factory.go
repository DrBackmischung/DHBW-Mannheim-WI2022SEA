package factory

import "fmt"

// Product interface
type Animal interface {
	Speak() string
}

// Concrete Products
type Dog struct{}

func (d *Dog) Speak() string {
	return "Woof!"
}

type Cat struct{}

func (c *Cat) Speak() string {
	return "Meow!"
}

// Factory interface
type AnimalFactory interface {
	CreateAnimal() Animal
}

// Concrete Factories
type DogFactory struct{}

func (df *DogFactory) CreateAnimal() Animal {
	return &Dog{}
}

type CatFactory struct{}

func (cf *CatFactory) CreateAnimal() Animal {
	return &Cat{}
}

// Client code
func main() {
	dogFactory := &DogFactory{}
	catFactory := &CatFactory{}

	dog := dogFactory.CreateAnimal()
	cat := catFactory.CreateAnimal()

	fmt.Println(dog.Speak()) // Output: Woof!
	fmt.Println(cat.Speak()) // Output: Meow!
}
