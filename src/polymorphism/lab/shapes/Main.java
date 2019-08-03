package polymorphism.lab.shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shape rectangle = new Rectangle(2.0, 3.1);
        Shape circle = new Circle(5.0);

        rectangle.calculateArea();
        circle.calculateArea();
        rectangle.calculatePerimeter();
        circle.calculatePerimeter();

        System.out.println(rectangle.getPerimeter());
        System.out.println(circle.getPerimeter());
        System.out.println(rectangle.getArea());
        System.out.println(circle.getArea());
    }
}
