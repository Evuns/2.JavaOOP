package encapsulation.exercise.pizzaCalorie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] nameToppingsNumber = bf.readLine().split("\\s+");
        String pizzaName = nameToppingsNumber[1];
        int numberOfToppings = Integer.parseInt(nameToppingsNumber[2]);
        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            String[] doughtData = bf.readLine().split("\\s+");
            String flourType = doughtData[1];
            String bakingTechnique = doughtData[2];
            double weightGrams = Double.parseDouble(doughtData[3]);
            try {
                Dough dough = new Dough(flourType, bakingTechnique, weightGrams);
                pizza.setDough(dough);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            String toppingsName;

            while (!"END".equalsIgnoreCase(toppingsName = bf.readLine())) {
                String[] toppingsData = toppingsName.split("\\s+");
                String toppingName = toppingsData[1];
                double toppingWeight = Double.parseDouble(toppingsData[2]);
                try {
                    Topping topping = new Topping(toppingName, toppingWeight);
                    pizza.addTopping(topping);
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    return;
                }
            }
            System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
