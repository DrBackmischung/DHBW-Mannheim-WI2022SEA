public class GraphicEditor {
    void drawShape(Shape shape) {
        if (shape instanceof Circle) {
            drawCircle((Circle) shape);
        } else if (shape instanceof Rectangle) {
            drawRectangle((Rectangle) shape);
        }
    }

    private void drawCircle(Circle circle) {
        System.out.println("Zeichne einen Kreis");
        // Zeichnen des Kreises
    }

    private void drawRectangle(Rectangle rectangle) {
        System.out.println("Zeichne ein Rechteck");
        // Zeichnen des Rechtecks
    }
}
