package WorkingWithAbstraction.Lab;

import java.io.*;

public class RhombusOfStars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int rowCounter = 1; rowCounter <= n ; rowCounter++) {
            printRow(n,rowCounter);
        }
        for (int downRows = n - 1; downRows > 0 ; downRows--) {
            printRow(n,downRows);
        }

    }

    private static void printRow(int n, int counter) {
        for (int spaces = 0; spaces < n - counter; spaces++) {
            System.out.print(" ");
        }
        for (int romb = 1; romb < counter; romb++) {
            System.out.print("* ");
        }
        System.out.println("*");

    }
}
