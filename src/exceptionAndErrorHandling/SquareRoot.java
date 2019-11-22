package exceptionAndErrorHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareRoot {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input = bf.readLine();
            try{
                int num = Integer.parseInt(input);
                if(num < 0){
                    throw new IllegalArgumentException("Square root for negative numbers is not define!");
                }

                System.out.println(Math.sqrt(num));

            } catch (NumberFormatException e){
                System.out.println("Not a number");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Good bye");
        }
    }
}
