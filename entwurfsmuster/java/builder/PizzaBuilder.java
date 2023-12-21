// Builder interface
public interface PizzaBuilder {
    void buildSize();

    void buildCheese();

    void buildPepperoni();

    void buildMushrooms();

    Pizza getResult();
}
