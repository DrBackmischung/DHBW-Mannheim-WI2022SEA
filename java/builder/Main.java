// Client code
public class Main {
    public static void main(String[] args) {
        MargheritaPizzaBuilder margheritaBuilder = new MargheritaPizzaBuilder();
        PizzaDirector director = new PizzaDirector(margheritaBuilder);

        director.constructPizza();
        Pizza margheritaPizza = margheritaBuilder.getResult();

        System.out.println(margheritaPizza);
    }
}
