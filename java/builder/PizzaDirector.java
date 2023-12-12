// Director
public class PizzaDirector {
    private PizzaBuilder pizzaBuilder;

    public PizzaDirector(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public void constructPizza() {
        pizzaBuilder.buildSize();
        pizzaBuilder.buildCheese();
        pizzaBuilder.buildPepperoni();
        pizzaBuilder.buildMushrooms();
    }
}
