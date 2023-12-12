// Concrete Builder
public class MargheritaPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public MargheritaPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildSize() {
        pizza.setSize("Medium");
    }

    @Override
    public void buildCheese() {
        pizza.setCheese(true);
    }

    @Override
    public void buildPepperoni() {
        // Margherita pizza doesn't have pepperoni
    }

    @Override
    public void buildMushrooms() {
        // Margherita pizza doesn't have mushrooms
    }

    @Override
    public Pizza getResult() {
        return pizza;
    }
}
