package polymorphism.lab.shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width){
        this.height = height;
        this.width = width;
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Double getWidth() {
        return this.width;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * (this.height + this.width));
    }

    @Override
    protected void calculateArea() {
        super.setArea(width * height);
    }
}
