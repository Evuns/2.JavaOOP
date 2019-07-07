package WorkingWithAbstraction.Lab.PointInRectangle;

public class Rectangle {
    int bottomLeftX;
    int bottomLeftY;
    int topRightX;
    int topRightY;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
        this.topRightX = topRightX;
        this.topRightY = topRightY;
    }

    public int getBottomLeftX() {
        return bottomLeftX;
    }

    public int getBottomLeftY() {
        return bottomLeftY;
    }

    public int getTopRightX() {
        return topRightX;
    }

    public int getTopRightY() {
        return topRightY;
    }

    public boolean contains(Point point){
        if(point.getCoordinateX() <= this.getTopRightX() && point.getCoordinateX() >= this.getBottomLeftX()
        && point.getCoordinateY() >= this.getBottomLeftY() && point.getCoordinateY() <= this.getTopRightY()){
            return true;
        }
        return false;
    }
}
