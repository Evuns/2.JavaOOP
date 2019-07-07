package WorkingWithAbstraction.Lab.HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(input[3].toUpperCase());

        Reservation reservation = new Reservation( pricePerDay,days,season,discountType);
        PriceCalculator priceCalculator = new PriceCalculator();
        System.out.println(priceCalculator.calculator(reservation));
    }
}
