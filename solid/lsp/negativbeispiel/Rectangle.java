public class Rectangle extends Shape {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Überschreibt die Methode, aber verletzt LSP
    @Override
    void calculateArea(int side) {
        // Berechnet die Fläche eines Rechtecks
        System.out.println("Fläche des Rechtecks: " + width * height);
    }
}