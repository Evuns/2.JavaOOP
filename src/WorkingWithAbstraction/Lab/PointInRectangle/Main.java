package WorkingWithAbstraction.Lab.PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String [] coordinatesRectangle = bf.readLine().split(" ");
        int bottomLeftX = Integer.parseInt(coordinatesRectangle[0]);
        int bottomLeftY = Integer.parseInt(coordinatesRectangle[1]);
        int topRightX = Integer.parseInt(coordinatesRectangle[2]);
        int topRightY = Integer.parseInt(coordinatesRectangle[3]);

        Rectangle rectangle = new Rectangle(bottomLeftX,bottomLeftY,topRightX,topRightY);

        int inputNumber = Integer.parseInt(bf.readLine());

        for (int i = 0; i < inputNumber ; i++) {
            String [] coordinatesPoint = bf.readLine().split(" ");
            int coordinateX = Integer.parseInt(coordinatesPoint[0]);
            int coordinateY = Integer.parseInt(coordinatesPoint[1]);
            Point point = new Point(coordinateX,coordinateY);
            System.out.println(rectangle.contains(point));
        }
    }
}
