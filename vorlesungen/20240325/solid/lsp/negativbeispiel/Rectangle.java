public class Rectangle extends Shape {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    void calculateArea(int side) {
        System.out.println("Fläche des Rechtecks: " + width * height);
    }
}