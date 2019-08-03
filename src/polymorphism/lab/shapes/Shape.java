package polymorphism.lab.shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();

    Double getPerimeter() {
        return perimeter;
    }

    void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    Double getArea() {
        return area;
    }

    void setArea(Double area) {
        this.area = area;
    }
}
