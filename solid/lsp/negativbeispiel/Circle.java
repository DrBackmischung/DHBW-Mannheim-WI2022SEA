public class Circle extends Shape {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Fläche des Kreises: " + area);
    }
}