package WorkingWithAbstraction.Exercise.JediGalaxy;

public class StarsMatrix {
    private int rows;
    private int cols;
    private int starMatrix [][];

    public StarsMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.starMatrix = galaxy();
    }

    public int[][] getStarMatrix() {
        return starMatrix;
    }

    private int [][] galaxy(){
        int [][] galaxy = new int[this.rows][this.cols];
        int value = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                galaxy[i][j] = value++;
            }
        }
        return galaxy;
    }
}
