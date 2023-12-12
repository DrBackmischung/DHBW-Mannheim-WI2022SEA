// Product
public class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;

    public Pizza() {
        // Initialize with default values
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public void setMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
    }

    @Override
    public String toString() {
        return "Pizza: Size(" + size + "), Cheese(" + cheese + "), Pepperoni(" + pepperoni + "), Mushrooms(" + mushrooms + ")";
    }
}
