package WorkingWithAbstraction.Exercise.JediGalaxy;

public class EvilPath {
    private int evilStartRow;
    private int evilStartCol;
    private int[][] galaxy;

    public EvilPath(int evilStartRow, int evilStartCol, int[][] galaxy) {
        this.evilStartRow = evilStartRow;
        this.evilStartCol = evilStartCol;
        this.galaxy = galaxy;
    }

    public int[][] path() {
        int currentRow = this.evilStartRow;
        int currentCol = this.evilStartCol;

        while (currentRow >= 0 && currentCol >= 0) {
            if (currentRow < galaxy.length && currentCol < galaxy[0].length) {
                galaxy[currentRow][currentCol] = 0;
            }
            currentRow--;
            currentCol--;
        }
        return galaxy;
    }
}
