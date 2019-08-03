package polymorphism.lab.shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    protected void calculateArea() {
        super.setArea(Math.PI * Math.pow(this.radius, 2));
    }
}
