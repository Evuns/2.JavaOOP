package exceptionAndErrorHandling;

import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter start index:");
        String inputStart = scanner.nextLine();

        try {
            int start = Integer.parseInt(inputStart);
            if (start < 1) {
                throw new IllegalArgumentException("Start index must be bigger than 1!");
            }
            System.out.println("Enter end index:");
            int end = Integer.parseInt(scanner.nextLine());
            if(end > 100){
                throw new IllegalArgumentException("End index must be smaller than 100!");
            } else if(end < start){
                throw new IllegalArgumentException("End index must be bigger than start index!");
            }
            System.out.println("Enter number:");
            int number = Integer.parseInt(scanner.nextLine());

            printNumber(start,end,number);
        } catch (NumberFormatException e) {
            System.err.println("Not a number!");
        }

    }

    private static void printNumber(int start, int end, int number) {
        if (number >= start && number <= end) {
            System.out.println(number);
        } else {
            throw new IllegalArgumentException(String.format("Number must be in range from %d to %d",start,end));
        }
    }
}
