package WorkingWithAbstraction.Exercise.JediGalaxy;

public class PlayerAdds {
    private int startRow;
    private int startCol;
    private int[][] damageGalaxy;

    public PlayerAdds(int startRow, int startCol, int[][] damageGalaxy) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.damageGalaxy = damageGalaxy;
    }

    public int values() {
        int value = 0;
        int currentRow = this.startRow;
        int currentCol = this.startCol;
        int [][] galaxy = this.damageGalaxy;
        while (currentRow >= 0 && currentCol < galaxy[1].length) {
            if (currentRow < galaxy.length && currentCol >= 0 && currentCol < galaxy[0].length) {
                value += galaxy[currentRow][currentCol];
            }
            currentCol++;
            currentRow--;
        }
        return value;
    }
}
