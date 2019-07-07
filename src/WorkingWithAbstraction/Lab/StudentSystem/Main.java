package WorkingWithAbstraction.Lab.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String data = scanner.nextLine();

        while (!data.equalsIgnoreCase("exit")){
            String[] input = data.split(" ");
            studentSystem.ParseCommand(input);
            data = scanner.nextLine();
        }
    }
}
