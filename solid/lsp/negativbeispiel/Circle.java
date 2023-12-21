public class Circle extends Shape {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    // Überschreibt die Methode korrekt
    @Override
    void calculateArea() {
        // Berechnet die Fläche eines Kreises
        double area = Math.PI * radius * radius;
        System.out.println("Fläche des Kreises: " + area);
    }
}