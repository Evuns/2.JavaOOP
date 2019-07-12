package WorkingWithAbstraction.Exercise.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = convertToArray(scanner.nextLine());
        int[][] galaxy = new StarsMatrix(dimensions[0], dimensions[1]).getStarMatrix();

        String command = scanner.nextLine();
        int sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] playerStartPosition = convertToArray(command);
            int[] evilStartPosition = convertToArray(scanner.nextLine());
            int[][] damageGalaxy = new EvilPath(evilStartPosition[0], evilStartPosition[1], galaxy).path();
            int value = new PlayerAdds(playerStartPosition[0], playerStartPosition[1], damageGalaxy).values();
            sum += value;

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    public static int [] convertToArray(String line){
        int [] array = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        return array;
    }
}
